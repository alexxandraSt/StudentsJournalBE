package com.studensJournal.repositories;

import com.studensJournal.entities.registration.Avatar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AvatarRepository extends CrudRepository<Avatar, Long> {

    Optional<Avatar> getAvatarByUserId(long userId);

}
