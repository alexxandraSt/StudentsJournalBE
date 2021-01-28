package com.studensJournal.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ServerConfig {

    @Bean
    public String clientAddress(
            @Value("${application.client.protocol}") String protocol,
            @Value("${application.client.host}") String host,
            @NotNull @Value("${application.client.port}") String port
    ) {
        if(port.equals(""))
        return protocol + "://" + host;

        return protocol + "://" + host + ":" + port;
    }
}