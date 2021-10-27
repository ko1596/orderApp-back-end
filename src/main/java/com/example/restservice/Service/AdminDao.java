package com.example.restservice.Service;

import com.example.restservice.Model.Coupon;
import com.example.restservice.Model.Admin.SaveOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public SaveOutput saveCoupon(Coupon coupon){

        System.out.println("EXCUTE INSERT COUPON\n");
        String sql = "INSERT INTO `project_database`.`coupon` (`title`, `is_enabled`, `percent`, `due_date`, `code`)"
        + "VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,
        coupon.getTitle(),
        coupon.getIs_enabled(),
        coupon.getPercent(),
        coupon.getDue_date(),
        coupon.getCode());
        
        return new SaveOutput(true, "已建立優惠券");
    }
}
