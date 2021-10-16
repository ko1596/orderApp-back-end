package com.example.restservice;


import javax.servlet.http.HttpServletRequest;

import com.example.restservice.Model.AddProduct;
import com.example.restservice.Model.Commentmodel;
import com.example.restservice.Model.Loginmember;
import com.example.restservice.Model.MemberAccount;
import com.example.restservice.Model.Seller;
import com.example.restservice.expection.LoginErrorException;
import com.google.gson.Gson;

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


	@RequestMapping("/SignUp_Member")
	public ResponseEntity SignUp(HttpServletRequest request) {
		MemberAccount memberAccount = new MemberAccount();
		memberAccount.setPassword(request.getParameter("password"));
		memberAccount.setName(request.getParameter("name"));
		memberAccount.setEmail(request.getParameter("email"));
		memberAccount.setBirthday(request.getParameter("birthday"));
		memberAccount.setPhone(request.getParameter("phone"));
		memberService.addMember(memberAccount);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/SignUp_Seller")
	public ResponseEntity SignUp_Seller(HttpServletRequest request) {
		Seller seller = new Seller();
		seller.setidMember(Integer.parseInt(request.getParameter("idMember")));
		seller.setName(request.getParameter("name"));
		seller.setPhone(Integer.parseInt(request.getParameter("phone")));
		seller.setDescription(request.getParameter("Description"));
		memberService.AddSeller(seller);
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
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/FindProduct_by_memberID")
	public ResponseEntity FindProduct_by_memberID(HttpServletRequest request) {
		String memberID = request.getParameter("memberID");
		String Sellerid = memberService.Findseller(memberID);
		List<AddProduct> collector = new ArrayList<>();
		collector = memberService.FindProduct(Sellerid);
		String json = new Gson().toJson(collector);
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}

	@RequestMapping("/Find_COMMENT_BY_Sellerid")
	public ResponseEntity Find_COMMENT_BY_Sellerid(HttpServletRequest request) 
	{
		String Sellerid = request.getParameter("Sellerid");
		Commentmodel commentmodel = new Commentmodel();
		commentmodel.setSellerid(Integer.parseInt(Sellerid));
		commentmodel.setRate(Integer.parseInt(request.getParameter("Rate")));
		commentmodel.setDescription(request.getParameter("Description"));
		memberService.AddComment(commentmodel);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping("/Postcomment_by_Sellerid")
	public ResponseEntity Postcomment_by_Sellerid(HttpServletRequest request) 
	{
		String Sellerid = request.getParameter("Sellerid");
		List<Commentmodel> collector = new ArrayList<>();
		collector = memberService.FindComment(Sellerid);
		String json = new Gson().toJson(collector);
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}

}