package com.studensJournal.security.jwt;


import com.studensJournal.entities.registration.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@RequiredArgsConstructor
public final class JwtUserFactory {

    public static JwtUser create(User user) {
      return   JwtUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .enabled(true)
                .password(user.getPassword())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(user.getUserRole().name())))
                .build();
    }
}
