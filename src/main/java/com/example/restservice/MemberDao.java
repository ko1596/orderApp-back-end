package com.example.restservice;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.example.restservice.Model.Product;
import com.example.restservice.Model.Commentmodel;
import com.example.restservice.Model.Loginmember;
import com.example.restservice.Model.MemberAccount;
import com.example.restservice.Model.Seller;
import com.example.restservice.Model.Shop_Cart;
import com.example.restservice.Model.ChangeMemberData;
import com.example.restservice.Rowmapper.CommentRowMapper;
import com.example.restservice.Rowmapper.MemberRowMapper;
import com.example.restservice.Rowmapper.ProductRowMapper;

import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Statement; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.stereotype.Repository; 
import java.sql.ResultSet;
import java.sql.Connection;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public void addMember(MemberAccount memberAccount)
	{
	  System.out.println("EXCUTE INSERT MEMBER");
	  jdbcTemplate.update("INSERT INTO `project_database`.`member` (`Name`, `password`, `Birthday`, `Phone`, `Email`)"
	  		+ "VALUES (?,?,?,?,?)" ,memberAccount.getName(),
			memberAccount.getPassword(),memberAccount.getBirthday(),memberAccount.getPhone(),memberAccount.getEmail());
  	}

	public void AddProduct(Product addProduct){	
		jdbcTemplate.update("INSERT INTO `project_database`.`product` (`Sellerid` , `Price`, `Name`, `Photo`, `Description`, `Status`, `Tag`)"
	  	+ "VALUES (?,?,?,?,?,?,?)" ,addProduct.getSellerid(),addProduct.getPrice(), addProduct.getName(),
	  	addProduct.getPhoto(),addProduct.getDescription(),addProduct.getStatus(),addProduct.getTag());
		
	}
	
	public String loginmember(Loginmember input)
	{ 
		String sql=" Select idMember from `project_database`.`member` where email=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{input.getemail(), input.getPassword()}, String.class);
	
	} 

	public void AddSeller(Seller seller){
		jdbcTemplate.update("INSERT INTO `project_database`.`Seller` (`idMember` , `Name` , `Phone` , `Description`)" + "VALUES (?,?,?,?)" , 
		seller.getidMember(),seller.getName(),seller.getPhone(),seller.getDescription());
	}

	public String Findseller(String memberid)
	{ 
		try{
			String sql=" Select Sellerid from `project_database`.`Seller` where idMember=?";
			return jdbcTemplate.queryForObject(sql, new Object[]{memberid}, String.class);
		}catch (DataAccessException e){
			e.printStackTrace();   
			return null;
		}		
	} 

	public  List<MemberAccount> findALLmember(String idMember)
	{
		String sql = "select * from (`project_database`.`member`)  where idMember=" + idMember;
		return jdbcTemplate.query(sql, new MemberRowMapper());
	}

	public  List<Product> findALLproduList(String sellerid)
	{
		String sql = "select * from `project_database`.`product`  where Sellerid=" + sellerid;
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	public void AddComment(Commentmodel commentmodel)
	{	
		jdbcTemplate.update("INSERT INTO `project_database`.`comment` (`Sellerid` ,`Rate` , `Description`)"
	  	+ "VALUES (?,?,?)" ,commentmodel.getSellerid(),commentmodel.getRate(), commentmodel.getDescription());	
	}

	public  List<Commentmodel> findALLCommentList(String sellerid)
	{
		String sql = "select * from `project_database`.`comment`  where Sellerid=" + sellerid;
		return jdbcTemplate.query(sql, new CommentRowMapper());
	}


	public void ChangeMemberData(ChangeMemberData changeMemberData)
	{
		String sql = "UPDATE member SET name=?, password=? , Birthday=? , Phone=? , Email=?  WHERE idMember=?;";
	    jdbcTemplate.update(sql,changeMemberData.getName(),
		changeMemberData.getPassword(),changeMemberData.getBirthday(),changeMemberData.getPhone(),changeMemberData.getEmail(),changeMemberData.getidmember());
  	}

	  public  List<Product> findProduct_by_ProductID(String Productid)
	  {
		  String sql = "select * from `project_database`.`product`  where ProductID=" + Productid;
		  return jdbcTemplate.query(sql, new ProductRowMapper());
	  }

	public void addShop_Cart(Shop_Cart shop_Cart)
	{
		jdbcTemplate.update("INSERT INTO `project_database`.`Shop_Cart` (`idmember` ,`quantity` , `ProductID`)"
		+ "VALUES (?,?,?)" ,shop_Cart.getidMember(),shop_Cart.getquantity(), shop_Cart.getProductID());
	}

	

}