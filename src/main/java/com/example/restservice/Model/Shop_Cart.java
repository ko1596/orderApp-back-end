package com.example.restservice.Model;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Shop_Cart {
    private int idMember;
    private int Orderid;
    private int quantity;
    private int ProductID;
    private List<Product> productList;


    public int getidMember(){
        return idMember;
    }
      
    public void setidMember(int idMember) {
        this.idMember = idMember;
    }

    public int getProductID() {
        return ProductID;
    }
    
    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }

    public int getquantity(){
        return quantity;
    }
      
    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return this.productList;
    }  
}
