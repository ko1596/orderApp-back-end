package com.example.restservice;
import java.util.List;
import com.example.restservice.AddProduct;
public class FindProductlist {
    private List<AddProduct> productList;

    public void setProductList(List<AddProduct> productList) {
        this.productList = productList;
    }

    public List<AddProduct> getProductList() {
        return this.productList;
    }  
}

