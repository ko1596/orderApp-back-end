package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.restservice.Model.Product;
import com.example.restservice.Model.ChangeMemberData;
import com.example.restservice.Model.Commentmodel;
import com.example.restservice.Model.Loginmember;
import com.example.restservice.Model.MemberAccount;
import com.example.restservice.Model.Shop_Cart;
import com.example.restservice.Model.Seller;
import com.example.restservice.expection.LoginErrorException;
import org.springframework.dao.EmptyResultDataAccessException;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	public void addMember(MemberAccount memberAccount){
		memberDao.addMember(memberAccount);
	}
	public String loginMember(Loginmember input){
		return memberDao.loginmember(input);
	}
	public void AddProduct(Product addProduct){
        memberDao.AddProduct(addProduct);
	}
	public void AddSeller(Seller seller){
		memberDao.AddSeller(seller);
	}

	public String Findseller(String memberid){
		return memberDao.Findseller(memberid);
	}
	public List<Product> FindProduct(String sellerid){
		return memberDao.findALLproduList(sellerid);
	}

	public void AddComment(Commentmodel commentmodel){
        memberDao.AddComment(commentmodel);
	}
	
	public List<Commentmodel> FindComment(String sellerid){
		return memberDao.findALLCommentList(sellerid);
	}

	public void ChangeMemberData(ChangeMemberData changeMemberData){
		memberDao.ChangeMemberData(changeMemberData);
	}

	public List<MemberAccount> findALLmember(String idmember){
		return memberDao.findALLmember(idmember);
	}

	public List<Product> FindProduct_by_Productid(String Productid)
	{
		return memberDao.findProduct_by_ProductID(Productid);
	}

	public void addShop_Cart(Shop_Cart shop_Cart){
		memberDao.addShop_Cart(shop_Cart);
	}

}
