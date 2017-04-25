package com.example;

import com.example.workflow.WordCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Wordconfiguration {

    @Bean
    public WordCounter getWordCounter()
    {
        return new WordCounter();
    }

}
