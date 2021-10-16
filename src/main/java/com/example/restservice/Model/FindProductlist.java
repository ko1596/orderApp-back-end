package com.example.restservice.Model;
import java.util.List;
public class FindProductlist {
    private List<AddProduct> productList;

    public void setProductList(List<AddProduct> productList) {
        this.productList = productList;
    }

    public List<AddProduct> getProductList() {
        return this.productList;
    }  
}

