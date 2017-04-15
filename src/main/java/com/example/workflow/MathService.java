package com.example.workflow;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.lang.String.valueOf;

public class MathService {

    public MathService() {
    }

    public String calculate(String operation, int x, int y) {
        if (operation != null) {
            if (operation.equalsIgnoreCase("subtract")) {
                int z = x - y;
                return valueOf(z);
            } else if (operation.equalsIgnoreCase("multiply")) {
                int z = x * y;
                return valueOf(z);
            } else if (operation.equalsIgnoreCase("divide")) {
                int z = x / y;
                return valueOf(z);
            } else if (operation.equalsIgnoreCase("add")) {
                int z = x + y;
                return valueOf(z);
            }
        } else {
            int z = x + y;
            return valueOf(z);
        }
        return null;
    }

    public String  calculateSum(MultiValueMap<String, String> querystring) {
        List<String> list = null;
        Integer sum = 0;
        for (String key : querystring.keySet()) {
            list = (List<String>) querystring.get(key);
            for (int i = 0; i < list.size(); i++)
                sum += Integer.parseInt(list.get(i));
        }
        return sum.toString();
    }
}