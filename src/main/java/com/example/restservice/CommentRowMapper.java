package com.example.restservice;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class CommentRowMapper implements RowMapper<Commentmodel>
{
    @Override
	public Commentmodel mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
		Commentmodel commentmodel = new Commentmodel();
		commentmodel.setProductID(rs.getInt("Sellerid"));
		commentmodel.setRate(rs.getInt("Price"));
		commentmodel.setDescription(rs.getString("Name"));
	
		return commentmodel;
	}
	
}



