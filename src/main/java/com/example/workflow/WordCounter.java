package com.example.workflow;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Primary
public class WordCounter {

    public Map<String, Integer> count(String inputString) {
        Map<String, Integer> test = new LinkedHashMap<String, Integer>();

        inputString = inputString.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = inputString.split("\\s");
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (!test.containsKey(words[i])) {
                j++;
                test.put(words[i], j);
            }
        }
        return test;
    }
}