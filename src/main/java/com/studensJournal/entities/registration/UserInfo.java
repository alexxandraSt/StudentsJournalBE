package com.studensJournal.entities.registration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studensJournal.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Entity
@Data
@Table(name = "users_info")
public class UserInfo extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @Column(name = "user_id")
    private long userId;

}
