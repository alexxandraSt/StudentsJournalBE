package com.studensJournal.repositories;

import com.studensJournal.entities.registration.User;
import com.studensJournal.entities.registration.UserRole;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

}
