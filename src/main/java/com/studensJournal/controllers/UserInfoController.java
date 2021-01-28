package com.studensJournal.controllers;

import com.studensJournal.config.rest.model.MvcResponse;
import com.studensJournal.config.rest.model.MvcResponseError;
import com.studensJournal.config.rest.model.MvcResponseObject;
import com.studensJournal.entities.registration.Avatar;
import com.studensJournal.entities.registration.User;
import com.studensJournal.security.jwt.JwtTokenProvider;
import com.studensJournal.services.interfaces.UserInfoService;
import com.studensJournal.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserInfoController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserInfoService userInfoService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @RequestMapping(value = "/upload/avatar", method = RequestMethod.POST, produces = "application/json")
    public MvcResponse uploadAvatar(@RequestBody String avatar, HttpServletRequest request) {

        try {

            User user = jwtTokenProvider.getUser(request);
            userInfoService.saveAvatar(new Avatar(user.getId(), avatar));
            return new MvcResponseObject(200, userInfoService.loadAvatar(user).orElse(null));
        } catch (Exception ex) {
            return new MvcResponseError(400, "Error saved");
        }
    }

    @RequestMapping(value = "/getAvatar", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Avatar> getAvatar(HttpServletRequest request) {
        Avatar avatar = userInfoService.loadAvatar(jwtTokenProvider.getUser(request)).orElse(null);
        return new ResponseEntity<>(avatar, HttpStatus.OK);
    }

    @RequestMapping(value = "/change_personal_info", method = RequestMethod.POST, produces = "application/json")
    public MvcResponse changPersonalInfo(@RequestBody Map<String, String> personalInfo, HttpServletRequest request) {
        try {

            User user = jwtTokenProvider.getUser(request);

            String oldPass = personalInfo.get("oldPassword");
            String newPass = personalInfo.get("newPassword");

            if (oldPass != null && !newPass.isEmpty()) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), oldPass));
                userService.changePassword(user, newPass);
            }

            //userInfoService.changePersonalInfo(personalInfo, user);

            return new MvcResponse(200);
        } catch (Exception ex) {
            return new MvcResponseError(400, "Error saved");
        }
    }

}