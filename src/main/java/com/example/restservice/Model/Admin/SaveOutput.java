package com.example.restservice.Model.Admin;

public class SaveOutput {
    private boolean success;
    private String message;

    public SaveOutput(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
