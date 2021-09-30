package com.example.restservice;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/api")
public class MemberController {
	//透過 @RequestMapping 指定從/會被對應到此hello()方法

	@Autowired
	MemberService memberService;


	// @CrossOrigin(origins = "*")
	@PostMapping(value = "/plus")
	// @ResponseBody
	public ResponseEntity<String> addWord(HttpServletRequest request) {
		String sol = String.valueOf(Integer.parseInt(request.getParameter("v1"))+Integer.parseInt(request.getParameter("v2")));
		return ResponseEntity.status(HttpStatus.OK).body(sol);
	}


	@RequestMapping("/SignUp")
	public ResponseEntity login(HttpServletRequest request) {
		MemberAccount memberAccount = new MemberAccount();
		memberAccount.setidMember(request.getParameter("account"));
		memberAccount.setPassword(request.getParameter("password"));
		memberAccount.setName(request.getParameter("name"));
		memberAccount.setEmail(request.getParameter("email"));
		memberAccount.setBirthday(request.getParameter("birthday"));
		memberAccount.getPhone(request.getParameter("phone"));
		memberService.addAccount(memberAccount);

		return new ResponseEntity(HttpStatus.OK);
	}
}