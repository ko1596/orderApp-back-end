package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class Commentmodel {
    private int Sellerid;
    private int Rate;
    private String Description;

    public int getSellerid(){
        return Sellerid;
    }
      
    public void setSellerid(int Sellerid) {
        this.Sellerid = Sellerid;
    }

    public int getRate(){
        return Rate;
    }
      
    public void setRate(int Rate) {
        this.Rate = Rate;
    }
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
}
