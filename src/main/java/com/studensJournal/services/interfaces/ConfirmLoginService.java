package com.studensJournal.services.interfaces;

import com.studensJournal.entities.confirm.ConfirmLogin;
import com.studensJournal.entities.registration.User;

public interface ConfirmLoginService {

    ConfirmLogin getByUser(User user);

    Boolean checkConfirmCode(User user, String code);

    ConfirmLogin createConfirmLogin(User user);

    ConfirmLogin createConfirmRestorePassword(User user);

    Long getUserIdByCode(String code);

    void deleteCode(ConfirmLogin code);

}
