package com.example.restservice;


public class LoginErrorException extends Exception{
    public LoginErrorException() {
        super("Can't login");
    } 
}
