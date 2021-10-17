package com.example.restservice.Model;


public class LoginOutput {
    private boolean success;
    private String message;
    private String id;

    public LoginOutput (Boolean success, String message, String id){
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public LoginOutput (Boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
