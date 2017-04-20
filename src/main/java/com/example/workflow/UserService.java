package com.example.workflow;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
@Service
public class UserService {
    public User1 getUser(Integer userId) {
        Predicate<User1> userPredicate = u-> u.getId()==(userId);
        User1 obj = list.stream().filter(userPredicate).findFirst().get();
        return obj;

    }

    public List<User1> getUsers() {
        return list;
    }

    private List<User1> list = new ArrayList<>();
    {
        Passenger passenger = new Passenger();
        passenger.setLastName("ss");
        passenger.setFirstName("ff");
        User1 user=new User1(20,"customer","sunil.gloabl@gmail.com",asList(passenger));
        list.add(user);
    }
}