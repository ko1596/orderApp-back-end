package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addMember(MemberAccount memberAccount){
		System.out.println("EXCUTE INSERT MEMBER");
	  jdbcTemplate.update("INSERT INTO `project_database`.`member` (`MemberType`, `Name`, `password`, `Birthday`, `Phone`, `Email`)"
	  		+ "VALUES (?,?,?,?,?,?)" ,memberAccount.getMemberType(), memberAccount.getName(),
	  		memberAccount.getPassword(),memberAccount.getBirthday(),memberAccount.getPhone(),memberAccount.getEmail());
  	}

	//public void LoginMember(MemberAccount memberAccount){
		//string sql = "SELECT * FROM `user` WHERE `username` = ? and `password` = ?";
		//jdbcTemplate.execute(sql);

	//}

	
}