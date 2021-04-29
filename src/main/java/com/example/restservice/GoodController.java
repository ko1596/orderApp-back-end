package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GoodController {
	//透過 @RequestMapping 指定從/會被對應到此hello()方法
	@Autowired
	MemberAccount memberAccount;
	
	@Autowired
	MemberService memberService;

	@PostMapping(value= "/Big")
    public String hello(){
    	memberAccount = new MemberAccount();
        System.out.println("new MemberAccount()");
    	memberAccount.setPassword("12345678");
    	memberAccount.setEmail("test@gmail.com");
    	memberAccount.setCellphone("0912345789");
    	memberAccount.setAddress("台北市");
        System.out.println("new MemberAccount add");
    	memberService.addMember(memberAccount);
        System.out.println("query");
        return "新增會員成功";
    }
}