package com.studensJournal.entities.registration;

import com.studensJournal.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "token")
public class UserToken extends BaseEntity {
    private long userId;
    private String token;
}
