package com.example.restservice;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ProductRowMapper implements RowMapper<AddProduct>
{
    @Override
	public AddProduct mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
		AddProduct addProduct = new AddProduct();
		addProduct.setSellerid(rs.getInt("Sellerid"));
		addProduct.setPrice(rs.getInt("Price"));
		addProduct.setName(rs.getString("Name"));
		addProduct.setPhoto(rs.getString("Photo"));
		addProduct.setDescription(rs.getString("Description"));
		addProduct.setStatus(rs.getString("Status"));
		addProduct.setTag(rs.getString("Tag"));
		
		return addProduct;
	}
	
}



