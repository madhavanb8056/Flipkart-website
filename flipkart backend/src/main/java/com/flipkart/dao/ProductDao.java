package com.flipkart.dao;

import java.util.List;



import com.flipkart.model.Catagory;
import com.flipkart.model.Product;

public interface ProductDao {
	
	public List<Product> getAllProducts();
	
	

	public List<Catagory> getAllCatagories();
	public List<Product> getProductsByCatagoryId(int id);
	public List<Product> searchProducts(String search);
	public Product getProductById(int id);
}
