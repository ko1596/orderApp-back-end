package com.example.restservice;
import org.springframework.stereotype.Component;

@Component
public class Loginmember {
    private String email;
    private String password;


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getemail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;
	}
}
