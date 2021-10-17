package com.example.restservice.Model;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Loginmember {
    private String email;
    private String password;
	private List<Loginmember> loginlList;


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

	public void setloginlList(List<Loginmember> loginlList) {
        this.loginlList = loginlList;
    }

    public List<Loginmember> getloginlList() {
        return this.loginlList;
    }  
}
