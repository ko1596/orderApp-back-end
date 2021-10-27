package com.example.restservice.Service;

import com.example.restservice.Model.Coupon;
import com.example.restservice.Model.Admin.SaveOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminDao repository;

    public SaveOutput save(Coupon coupon){
        return repository.saveCoupon(coupon);
    }
}
