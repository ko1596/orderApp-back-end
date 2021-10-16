package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class Commentmodel {
    private int ProductID;
    private int Rate;
    private String Description;

    public int getProductID(){
        return ProductID;
    }
      
    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
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
