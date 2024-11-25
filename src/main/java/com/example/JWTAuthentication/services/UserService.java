package com.example.JWTAuthentication.services;

import com.example.JWTAuthentication.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User>store=new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Shubham Patil",
                "shubham.patil@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Yash Bhange",
                "yash.bhange@gmail.com"));
    }

    public List<User>getUsers(){
        return this.store;
    }
}
