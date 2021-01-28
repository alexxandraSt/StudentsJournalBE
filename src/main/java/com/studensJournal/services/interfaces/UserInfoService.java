package com.studensJournal.services.interfaces;

import com.studensJournal.dto.RegistrationUserDTO;
import com.studensJournal.entities.registration.Avatar;
import com.studensJournal.entities.registration.User;
import com.studensJournal.entities.registration.UserInfo;

import java.util.Optional;

public interface UserInfoService {

    void saveAvatar(Avatar avatar);

    Optional<Avatar> loadAvatar(User user);

    Optional<Avatar> loadAvatar(Long userId);

    void removeAvatar(Long userId);

    Optional<UserInfo> getByUser(User user);

    void createDefaultUserInfo(User user, RegistrationUserDTO userDTO);

}
