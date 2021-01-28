package com.studensJournal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserDTO {
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String phone;
    private String country;
}
