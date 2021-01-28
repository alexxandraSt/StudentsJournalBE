package com.studensJournal.controllers;

import com.studensJournal.config.rest.model.MvcResponse;
import com.studensJournal.config.rest.model.MvcResponseError;
import com.studensJournal.config.rest.model.MvcResponseObject;
import com.studensJournal.dto.AuthorizationDTO;
import com.studensJournal.dto.RestorePassDTO;
import com.studensJournal.entities.confirm.ConfirmLogin;
import com.studensJournal.entities.registration.User;
import com.studensJournal.exceptions.RegistrationValidDataException;
import com.studensJournal.security.jwt.JwtTokenProvider;
import com.studensJournal.services.interfaces.ConfirmLoginService;
import com.studensJournal.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api")
public class AuthenticationController {

    @Autowired
    private String clientAddress;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
//    private final EmailSender emailSender;
    private final ConfirmLoginService confirmLoginService;

    @PostMapping("authorization")
    public MvcResponse login(@RequestBody AuthorizationDTO authorization) {
        try {
            User user = userService.findByEmail(authorization.getEmail());


            if (user == null) {
                throw new UsernameNotFoundException("User with email: " + authorization.getEmail() + " not found");
                //return new MvcResponseError(400, "User with email: " + authorization.getEmail() + " not found");
            }

            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authorization.getEmail(), authorization.getPassword()));
            } catch (AuthenticationException e) {
                throw new UsernameNotFoundException("Wrong password!");
            }

            String token = jwtTokenProvider.createToken(authorization.getEmail());
            userService.saveUserToken(user, token);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", authorization.getEmail());
            response.put("token", token);

            return new MvcResponseObject(200, response);
        } catch (Exception e) {
            return new MvcResponseError(400, e.getMessage());
        }
    }


    @PostMapping("check_token")
    public ResponseEntity test(HttpServletRequest req) {
        try {
            return ResponseEntity.ok(null);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PermitAll
    @PostMapping("restore_password")
    public MvcResponse restorePasswordCheckEmail(@RequestParam String email) {
        try {
            User user = userService.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User with email: " + email + " not found");
            }

            log.info("Start restore password...");
            log.info("User : {}", email);

            ConfirmLogin confirmRestorePassword = confirmLoginService.createConfirmRestorePassword(user);
            String link = String.format("%snew?type=r&token=%s", clientAddress, confirmRestorePassword.getCode());

            //emailSender.sendEmailOnRestorePasswordConfirm(user.getEmail(), link);

            log.info("Send link : {}", link);

            return new MvcResponse(200);
        } catch (Exception e) {
            return new MvcResponseError(400, e.getMessage());
        }
    }

    @PermitAll
    @PostMapping("restore_password/token")
    public MvcResponse restorePasswordCheckToken(@RequestBody RestorePassDTO dto) {
        try {
            User user = userService.findById(confirmLoginService.getUserIdByCode(dto.getToken()));

            if (user == null) {
                throw new UsernameNotFoundException("");
            }

            if (confirmLoginService.checkConfirmCode(user, dto.getToken())) {
                userService.changePassword(user, dto.getPassword());
                log.info("Success change password user {}", user.getEmail());
            }

            return new MvcResponse(200);
        } catch (AuthenticationException e) {
            return new MvcResponseError(400, "Invalid token");
        }
    }


}
