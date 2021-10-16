package com.example.restservice.Model;

import org.springframework.stereotype.Component;

@Component
public class ChangeMemberData {
    private String Name;
    private String password;
    private String Birthday;
    private String Phone;
    private String Email;


    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getPhone() {
        return Phone;
    }
    
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
