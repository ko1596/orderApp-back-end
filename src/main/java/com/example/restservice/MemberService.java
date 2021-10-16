package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.restservice.Model.AddProduct;
import com.example.restservice.Model.Commentmodel;
import com.example.restservice.Model.Loginmember;
import com.example.restservice.Model.MemberAccount;
import com.example.restservice.Model.Seller;
import com.example.restservice.expection.LoginErrorException;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	public void addMember(MemberAccount memberAccount){
		memberDao.addMember(memberAccount);
	}
	public String loginMember(Loginmember input)  throws LoginErrorException{
		return memberDao.loginmember(input);
	}
	public void AddProduct(AddProduct addProduct){
        memberDao.AddProduct(addProduct);
	}
	public void AddSeller(Seller seller){
		memberDao.AddSeller(seller);
	}

	public String Findseller(String memberid){
		return memberDao.Findseller(memberid);
	}
	public List<AddProduct> FindProduct(String sellerid){
		return memberDao.findALLproduList(sellerid);
	}

	public void AddComment(Commentmodel commentmodel){
        memberDao.AddComment(commentmodel);
	}
	
	public List<Commentmodel> FindComment(String sellerid){
		return memberDao.findALLCommentList(sellerid);
	}
}
