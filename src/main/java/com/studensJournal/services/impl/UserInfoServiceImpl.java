package com.studensJournal.services.impl;

import com.studensJournal.dto.RegistrationUserDTO;
import com.studensJournal.entities.registration.Avatar;
import com.studensJournal.entities.registration.User;
import com.studensJournal.entities.registration.UserInfo;
import com.studensJournal.repositories.AvatarRepository;
import com.studensJournal.repositories.UserInfoRepository;
import com.studensJournal.services.interfaces.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final AvatarRepository avatarRepository;

    @Override
    @Transactional
    public void saveAvatar(Avatar avatar) {
        if (loadAvatar(avatar.getUserId()).isPresent()) {
            removeAvatar(avatar.getUserId());
        }
        avatarRepository.save(avatar);
    }

    @Override
    public Optional<Avatar> loadAvatar(User user) {
        return avatarRepository.getAvatarByUserId(user.getId());
    }

    @Override
    public Optional<Avatar> loadAvatar(Long userId) {
        return avatarRepository.getAvatarByUserId(userId);
    }

    @Override
    public void removeAvatar(Long userId) {
        avatarRepository.delete(loadAvatar(userId).get());
    }

    @Override
    public Optional<UserInfo> getByUser(User user) {
        return userInfoRepository.getByUserId(user.getId());
    }

    @Override
    public void createDefaultUserInfo(User user, RegistrationUserDTO userDTO) {
        UserInfo userInfo = new UserInfo();

        userInfo.setCountry(userDTO.getCountry());
        userInfo.setEmail(user.getEmail());
        userInfo.setName(userDTO.getName());
        userInfo.setPhone(userDTO.getPhone());
        userInfo.setNickName(userDTO.getNickName());
        userInfo.setUserId(user.getId());

        userInfoRepository.save(userInfo);
    }
}
