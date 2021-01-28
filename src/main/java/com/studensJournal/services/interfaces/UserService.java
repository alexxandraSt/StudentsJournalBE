package com.studensJournal.services.interfaces;

import com.studensJournal.dto.RegistrationUserDTO;
import com.studensJournal.entities.registration.User;
import com.studensJournal.entities.registration.UserToken;
import com.studensJournal.exceptions.RegistrationValidDataException;

import java.io.IOException;

public interface UserService {

    User findByEmail(String email);

    User findById(Long id);

    void register(RegistrationUserDTO userDTO) throws RegistrationValidDataException, IOException;

    void changePassword(User user,String newPassword);

    UserToken getTokenByUserEmail(String email);

    void saveUserToken(User user, String token);

}
