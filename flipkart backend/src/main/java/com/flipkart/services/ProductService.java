package com.flipkart.services;

import java.util.List;

import com.flipkart.model.Catagory;
import com.flipkart.model.Product;

public interface ProductService {
	


	public List<Product> getAllProducts();
	
	public List<Catagory> getAllCatagories();
	
	public List<Product> getProductsByCatagoryId(int id);

}
