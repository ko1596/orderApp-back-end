package com.example.restservice;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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
	public ResponseEntity SignUp(HttpServletRequest request) {
		MemberAccount memberAccount = new MemberAccount();
		String Role = request.getParameter("Type");
		memberAccount.setPassword(request.getParameter("password"));
		memberAccount.setName(request.getParameter("name"));
		memberAccount.setEmail(request.getParameter("email"));
		memberAccount.setBirthday(request.getParameter("birthday"));
		memberAccount.setPhone(request.getParameter("phone"));
		memberService.addMember(memberAccount);
        if(Role.equals("Seller")){
			String id;
			Loginmember loginmember = new Loginmember();
			loginmember.setemail(request.getParameter("email"));
			loginmember.setPassword(request.getParameter("password"));
			try {
				id = memberService.loginMember(loginmember);
				memberService.AddSeller(id);
			} 
			catch (LoginErrorException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
			}
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/Login")
	public ResponseEntity Login(HttpServletRequest request) {
		String result;
		Loginmember loginmember = new Loginmember();
		loginmember.setemail(request.getParameter("email"));
		loginmember.setPassword(request.getParameter("password"));
		try {
			result = memberService.loginMember(loginmember);
		} 
		catch (LoginErrorException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@RequestMapping("/add_product")
	public ResponseEntity add_product(HttpServletRequest request) {
		String memberID = request.getParameter("memberID");
		String Sellerid = memberService.Findseller(memberID);
		AddProduct addProduct = new AddProduct();
		addProduct.setSellerid(Integer.parseInt(Sellerid));
		addProduct.setPrice(Integer.parseInt(request.getParameter("Price")));
		addProduct.setName(request.getParameter("Name"));
		addProduct.setPhoto(request.getParameter("Photo"));
		addProduct.setDescription(request.getParameter("Description"));
		addProduct.setStatus(request.getParameter("Status"));
		addProduct.setTag(request.getParameter("Tag"));
		memberService.AddProduct(addProduct);
		System.out.println(Sellerid);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/PostProduct")
	public ResponseEntity PostProduct(HttpServletRequest request) {
		String memberID = request.getParameter("memberID");
		String Sellerid = memberService.Findseller(memberID);
		System.out.println(memberID);
		System.out.println(Sellerid);
		List<AddProduct> collector = new ArrayList<>();
		collector = memberService.FindProduct(Sellerid);
		for(int i =0 ; i < collector.size() ; i++){
			System.out.println(collector.get(i).getName());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("GOOD");
	}


}