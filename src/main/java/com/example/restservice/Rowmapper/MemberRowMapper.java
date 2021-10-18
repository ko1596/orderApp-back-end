package com.example.restservice.Rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.restservice.Model.MemberAccount;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberAccount>{
    @Override
	public MemberAccount mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
		MemberAccount addmember = new MemberAccount();
        addmember.setidmember(rs.getInt("idmember"));
		addmember.setEmail(rs.getString("Email"));
		addmember.setPhone(rs.getString("Phone"));
		addmember.setName(rs.getString("Name"));
		addmember.setPassword(rs.getString("Password"));
		addmember.setBirthday(rs.getString("Birthday"));
		
		return addmember;
	}
}
