package com.example.restservice;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import com.example.restservice.MemberAccount; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.stereotype.Repository; 
import java.sql.ResultSet;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public void addMember(MemberAccount memberAccount)
	{
	  System.out.println("EXCUTE INSERT MEMBER");
	  jdbcTemplate.update("INSERT INTO `project_database`.`member` (`MemberType`, `Name`, `password`, `Birthday`, `Phone`, `Email`)"
	  		+ "VALUES (?,?,?,?,?,?)" ,memberAccount.getMemberType(), memberAccount.getName(),
	  		memberAccount.getPassword(),memberAccount.getBirthday(),memberAccount.getPhone(),memberAccount.getEmail());
  	}
	
	@Autowired 
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { 
			this.jdbcTemplate = jdbcTemplate;
		} 
		public String loginmember(Loginmember input)
		{ 
			try{
				String sql=" Select Name from `project_database`.`member` where email=? and password=?";
				RowMapper<String> rowMapper = new BeanPropertyRowMapper<String>(String.class);
			    String a = jdbcTemplate.queryForObject(sql ,rowMapper,input.getemail(), input.getPassword()); 
				System.out.println(a);
				return a;
			}catch (DataAccessException e){
				e.printStackTrace();   
				return null;
			}
			
		} 
}