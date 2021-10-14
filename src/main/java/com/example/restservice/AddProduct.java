package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class AddProduct {
    private int Sellerid;
    private int Price;
    private String Name;
    private String Photo;
    private String Description;
    private String Status;
    private String Tag;

    public int getSellerid(){
        return Sellerid;
    }
      
    public void setSellerid(int Sellerid) {
        this.Sellerid = Sellerid;
    }

    public int getPrice(){
        return Price;
    }
      
    public void setPrice(int Price) {
        this.Price = Price;
    }
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getPhoto() {
        return Photo;
    }
    
    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
    this.Status = Status;
    }
    
    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    
}
