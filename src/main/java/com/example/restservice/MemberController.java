package com.example.restservice;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController

public class MemberController {
	//透過 @RequestMapping 指定從/會被對應到此hello()方法
	@Autowired
	UserData userData;

	@Autowired
	MemberService memberService;
	// @RequestMapping("/")
    // public String hello(){
    // 	memberAccount = new MemberAccount();
    //     System.out.println("new MemberAccount()");
    // 	memberAccount.setPassword("654654");
    // 	memberAccount.setEmail("aaa@gmail.com");
    // 	memberAccount.setCellphone("0912354678");
    // 	memberAccount.setAddress("台中市");
    //     System.out.println("new MemberAccount add");
    // 	memberService.addMember(memberAccount);
    //     System.out.println("query");
    //     return "新增會員成功";
    // }

	@RequestMapping("/plus")
	@ResponseBody
	public String addWord(HttpServletRequest request) {
		String sol = String.valueOf(Integer.parseInt(request.getParameter("v1"))+Integer.parseInt(request.getParameter("v2")));
		return sol;
	}

	@RequestMapping("/minus")
	@ResponseBody
	public String minusWord(HttpServletRequest request) {
		String sol = String.valueOf(Integer.parseInt(request.getParameter("v1"))-Integer.parseInt(request.getParameter("v2")));
		return sol;
	}

	@RequestMapping("/login")
	@ResponseBody
	public ResponseEntity login(HttpServletRequest request) {
		userData = new UserData();
		userData.setID(request.getParameter("account"));
		userData.setPassword(request.getParameter("password"));
		memberService.addAccount(userData);

		return new ResponseEntity(HttpStatus.OK);
	}

	@Bean
	public WebMvcConfigurer configurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/*").allowedOrigins("https://127.0.0.1:5500");
			}
		};
	}
}