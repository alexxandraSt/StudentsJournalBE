package com.studensJournal.services.impl;

import com.studensJournal.entities.confirm.ConfirmLogin;
import com.studensJournal.entities.registration.User;
import com.studensJournal.repositories.ConfirmLoginRepository;
import com.studensJournal.services.interfaces.ConfirmLoginService;
import com.studensJournal.utils.rand.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmLoginServiceImpl implements ConfirmLoginService {

    private final ConfirmLoginRepository confirmLoginRepository;

    @Override
    public ConfirmLogin getByUser(User user) {
        return confirmLoginRepository.getByUserId(user.getId()).orElse(null);
    }

    @Override
    public Boolean checkConfirmCode(User user, String code) {
        ConfirmLogin confirmLogin = getByUser(user);
        return confirmLogin != null && confirmLogin.getCode().equals(code);
    }

    @Override
    public ConfirmLogin createConfirmLogin(User user) {
        ConfirmLogin confirmLogin = getByUser(user);

        if (confirmLogin == null) {
            confirmLogin = new ConfirmLogin();
            confirmLogin.setCode(Random.getRandomConfirmLoginCode());
            confirmLogin.setUserId(user.getId());
        } else {
            confirmLogin.setCreated(new Date().getTime());
            confirmLogin.setCode(Random.getRandomConfirmLoginCode());
        }

        return confirmLoginRepository.save(confirmLogin);
    }

    @Override
    public ConfirmLogin createConfirmRestorePassword(User user) {
        ConfirmLogin confirmLogin = getByUser(user);

        if (confirmLogin == null) {
            confirmLogin = new ConfirmLogin();
            confirmLogin.setCode(Random.getRandomHash(33));
            confirmLogin.setUserId(user.getId());
        } else {
            confirmLogin.setCreated(new Date().getTime());
            confirmLogin.setCode(Random.getRandomHash(33));
        }

        return confirmLoginRepository.save(confirmLogin);
    }

    @Override
    public Long getUserIdByCode(String code) {
        return confirmLoginRepository.getByCode(code).getUserId();
    }

    @Override
    public void deleteCode(ConfirmLogin code) {
        confirmLoginRepository.delete(code);
    }

}
