package com.example.restservice;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	  		+ "VALUES (?,?,?,?,?)" ,memberAccount.getName(),memberAccount.getPassword(),memberAccount.getBirthday(),memberAccount.getPhone(),memberAccount.getEmail());
  	}

	public void AddProduct(AddProduct addProduct){	
		jdbcTemplate.update("INSERT INTO `project_database`.`product` (`Sellerid` , `Price`, `Name`, `Photo`, `Description`, `Status`, `Tag`)"
	  	+ "VALUES (?,?,?,?,?,?,?)" ,addProduct.getSellerid(),addProduct.getPrice(), addProduct.getName(),
	  	addProduct.getPhoto(),addProduct.getDescription(),addProduct.getStatus(),addProduct.getTag());
		
	}
	
	public String loginmember(Loginmember input)
	{ 
		try{
			String sql=" Select idMember from `project_database`.`member` where email=? and password=?";
			return jdbcTemplate.queryForObject(sql, new Object[]{input.getemail(), input.getPassword()}, String.class);
		}catch (DataAccessException e){
			e.printStackTrace();   
			return null;
		}		
	} 

	public void AddSeller(String id){
		jdbcTemplate.update("INSERT INTO `project_database`.`Seller` (`idMember`)" + "VALUES (?)" , id);
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

	public  List<AddProduct> findALLproduList(String sellerid)
	{
		String sql = "select * from `project_database`.`product`  where Sellerid=" + sellerid;
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}




}