package com.example.restservice.Model;

import org.springframework.stereotype.Component;

@Component
public class Coupon {

    private String title;
    private int is_enabled;
    private int percent;
    private int due_date;
    private String code;

    public Coupon() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(int is_enabled) {
        this.is_enabled = is_enabled;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getDue_date() {
        return due_date;
    }

    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return title +"\n"+ is_enabled +"\n"+ percent +"\n"+ due_date+"\n" + code+"\n";
    }
}