package com.example.api;

import com.example.workflow.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordController {

    private final WordCounter obj;

    public WordController(WordCounter obj){
        this.obj=obj;
    }
    @PostMapping("/words/count")
    public Map<String, Integer> countWords(@RequestBody String input)
    {
        System.out.println(input);
            return obj.count(input);


    }
}
