package com.example.restservice.Rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.restservice.Model.Commentmodel;

import org.springframework.jdbc.core.RowMapper;


public class CommentRowMapper implements RowMapper<Commentmodel>
{
    @Override
	public Commentmodel mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
		Commentmodel commentmodel = new Commentmodel();
		commentmodel.setSellerid(rs.getInt("Sellerid"));
		commentmodel.setRate(rs.getInt("Rate"));
		commentmodel.setDescription(rs.getString("Description"));
	
		return commentmodel;
	}
	
}



