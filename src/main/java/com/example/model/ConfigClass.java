package com.example.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

    @Bean
    public Baz getBaz()
    {
        return new Baz();
    }
}
