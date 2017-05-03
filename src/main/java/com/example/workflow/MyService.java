package com.example.workflow;

import com.example.MyConfig;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyConfig config;

    public MyService(MyConfig config) {
        this.config = config;
    }

    public String getUrlFromConfig() {
        return config.getUrl();
    }

    public String getusernamefromconfig() {
        return config.getUsername();
    }

}
