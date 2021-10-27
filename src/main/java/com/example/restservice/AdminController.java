package com.example.restservice;

import com.example.restservice.Model.Coupon;
import com.example.restservice.Model.Admin.SaveOutput;
import com.example.restservice.Service.AdminService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    AdminService repository;

    @PostMapping(value = "/coupon")
    public ResponseEntity<String> create(@RequestBody Coupon item) {
        try {
            SaveOutput savedItem = repository.save(item);
            return new ResponseEntity<String>(new Gson().toJson(savedItem), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}