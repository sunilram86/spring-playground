package com.example.workflow;

import com.example.WordCountConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyNewService {
    private final WordCountConfig wordCountConfig;

    public MyNewService(WordCountConfig wordCountConfig) {
        this.wordCountConfig = wordCountConfig;
    }

    public Boolean getCaseSensitive() {
        return wordCountConfig.getCaseSensitive();
    }


    public List<String> getFilterWords() {
        return wordCountConfig.getWords().getSkip();
    }


}
