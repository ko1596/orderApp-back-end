package com.example.restservice.Model;

import java.util.List;


public class MemberOutput {
    private boolean success;
    private List<MemberAccount> Product;
    private String messange;

    public MemberOutput (Boolean success, List<MemberAccount> Product)
    {
        this.success = success;
        this.Product = Product;
    }

    public MemberOutput (Boolean success , String messange){
        this.success = success;
        this.messange = messange;

    }

}
