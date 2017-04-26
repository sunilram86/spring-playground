package com.example.workflow;


import com.example.MyConfig;
import com.example.WordCountConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordCounter {

    private final WordCountConfig config;

    public WordCounter(WordCountConfig config) {
        this.config = config;
    }

    public List<String> getSkipword() {
        return config.getWords().getSkip();
    }


    public Map<String, Integer> count(String inputString) {
        Map<String, Integer> test = new LinkedHashMap<String, Integer>();

        List<String> skipWords = getSkipword();

        inputString = inputString.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

        List<String> myList = new ArrayList<>(Arrays.asList(inputString.split(" ")));

        myList.removeAll(skipWords);

        for (int i = 0; i < myList.size(); i++) {
            if (!test.containsKey(myList.get(i))) {

                test.put(myList.get(i), Collections.frequency(myList, myList.get(i)));
            }
        }
        return test;
    }
}