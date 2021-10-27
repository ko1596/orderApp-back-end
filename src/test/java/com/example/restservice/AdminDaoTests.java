package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.restservice.Model.Coupon;
import com.example.restservice.Model.Admin.SaveOutput;
import com.example.restservice.Service.AdminDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminDaoTests {

    @Autowired
    private AdminDao repository;
    
    @Test
    public void addCouponTest() throws Exception {
        Coupon coupon = new Coupon();
        
        coupon.setTitle("超級特惠價格");
        coupon.setIs_enabled(1);
        coupon.setPercent(80);
        coupon.setDue_date(1555459200);
        coupon.setCode("testCode");

        SaveOutput actual = repository.saveCoupon(coupon);
        SaveOutput expected = new SaveOutput(true, "已建立優惠券");

        assertEquals(expected, actual);
    }
}
