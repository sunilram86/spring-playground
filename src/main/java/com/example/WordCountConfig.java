package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("wordCount")
public class WordCountConfig {
    private Boolean caseSensitive;
    private Words words;

    public WordCountConfig() {
    }

    public WordCountConfig(Boolean caseSensitive, Words words) {
        this.caseSensitive = caseSensitive;
        this.words = words;
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

    public static class Words {

        private List<String> skip;

        public Words() {
        }

        public List<String> getSkip() {
            return skip;
        }

        public void setSkip(List<String> skip) {
            this.skip = skip;
        }
    }


}

