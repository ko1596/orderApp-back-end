package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class Seller {
    private int idMember;
    private int Phone;
    private String Name;
    private String Description;

    public int getidMember(){
        return idMember;
    }
      
    public void setidMember(int idMember) {
        this.idMember = idMember;
    }

    public int getPhone(){
        return Phone;
    }
      
    public void setPhone(int Phone) {
        this.Phone = Phone;
    }
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
}
