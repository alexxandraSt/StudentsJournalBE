package com.studensJournal.services.impl;

import com.studensJournal.dto.RegistrationUserDTO;
import com.studensJournal.entities.registration.User;
import com.studensJournal.entities.registration.UserRole;
import com.studensJournal.entities.registration.UserToken;
import com.studensJournal.exceptions.RegistrationValidDataException;
import com.studensJournal.repositories.UserRepository;
import com.studensJournal.repositories.UserTokenRepository;
import com.studensJournal.services.interfaces.UserInfoService;
import com.studensJournal.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.EmailValidator;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserInfoService userInfoService;
    private final UserTokenRepository userTokenRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void register(RegistrationUserDTO userDTO) throws RegistrationValidDataException {
        User user = saveUser(createUser(userDTO)
                .orElseThrow(() -> new IllegalStateException("It is not possible to create a new user")));

        userInfoService.createDefaultUserInfo(user, userDTO);
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }

    private Optional<User> createUser(RegistrationUserDTO userDTO) throws RegistrationValidDataException {
        validRegistrationUserDTO(userDTO);
        String encodedPass = passwordEncoder.encode(userDTO.getPassword());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(encodedPass);
        user.setUserRole(UserRole.ROLE_USER);
        user.setCreated(new Date().getTime());
        return Optional.of(user);
    }

    private void validRegistrationUserDTO(RegistrationUserDTO userDTO) throws RegistrationValidDataException {
        if (userRepository.findUserByEmail(userDTO.getEmail()).isPresent()) {
            throw new RegistrationValidDataException("Email is un ready in use");
        }
        if (!passwordInputIsValid(userDTO.getPassword())) {
            throw new RegistrationValidDataException("Invalid password");
        }
        if (!emailInputIsValid(userDTO.getEmail())) {
            throw new RegistrationValidDataException("Invalid email");
        }
    }

    @Override
    public void changePassword(@NotNull User user, String newPassword) {

        if ( !passwordInputIsValid(newPassword) ) {
            throw new RuntimeException("Wrong password");
        }
        String newPass = passwordEncoder.encode(newPassword);
        user.setPassword(newPass);
        saveUser(user);
    }

    @Override
    public UserToken getTokenByUserEmail(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow(RuntimeException::new);
        return userTokenRepository.findByUserId(user.getId());
    }

    @Override
    public void saveUserToken(User user, String token) {
        UserToken userToken = getTokenByUserEmail(user.getEmail());

        if (getTokenByUserEmail(user.getEmail()) == null) {
            userToken = new UserToken();
            userToken.setUserId(user.getId());
        }
        userToken.setToken(token);
        userTokenRepository.save(userToken);
    }

    private boolean passwordInputIsValid(String password) {
        // String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}";

        //return (password.matches(pattern));
        if (password.length() > 4)
            return true;
        else return false;
    }

    private boolean emailInputIsValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

}
