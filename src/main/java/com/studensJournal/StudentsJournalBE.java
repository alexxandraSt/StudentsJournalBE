package com.studensJournal;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsJournalBE {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(StudentsJournalBE.class, args);
    }

}
