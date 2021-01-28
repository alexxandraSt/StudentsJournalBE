package com.studensJournal.dto;

import lombok.Data;

@Data
public class RestorePassDTO {
    private String token;
    private String password;
}
