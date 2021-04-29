package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class UserData {
    private String id;
    private String password;

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setID(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    
}
