package com.studensJournal.repositories;

import com.studensJournal.entities.registration.UserToken;
import org.springframework.data.repository.CrudRepository;

public interface UserTokenRepository extends CrudRepository<UserToken, Long> {

    UserToken findByUserId(long userId);
}
