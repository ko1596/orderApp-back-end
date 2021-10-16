package com.example.restservice.expection;


public class LoginErrorException extends Exception{
    public LoginErrorException() {
        super("Can't login");
    } 
}
