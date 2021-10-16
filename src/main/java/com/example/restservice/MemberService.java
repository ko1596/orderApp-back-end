package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
	public void AddSeller(String id){
		memberDao.AddSeller(id);
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
