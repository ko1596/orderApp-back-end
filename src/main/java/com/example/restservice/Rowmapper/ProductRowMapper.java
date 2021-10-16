package com.example.restservice.Rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.restservice.Model.Product;

import org.springframework.jdbc.core.RowMapper;


public class ProductRowMapper implements RowMapper<Product>
{
    @Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
		Product addProduct = new Product();
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



