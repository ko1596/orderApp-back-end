package com.example.restservice.Model;
import java.util.List;
public class FindProductlist {
    private List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return this.productList;
    }  
}

