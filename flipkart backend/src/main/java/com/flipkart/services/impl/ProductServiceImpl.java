package com.flipkart.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flipkart.dao.ProductDao;
import com.flipkart.model.Catagory;
import com.flipkart.model.Product;
import com.flipkart.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
		}

	public List<Product> getAllProducts(){
		
		return productDao.getAllProducts();
		}
	
	public List<Catagory> getAllCatagories() {
		return productDao.getAllCatagories();

	}
	public List<Product> searchProducts(String search){
		return productDao.searchProducts(search);
		
	}


	public List<Product> getProductsByCatagoryId(int id) {
		return productDao.getProductsByCatagoryId(id);
	}
	
	public Product getProductById(int id){
		return productDao.getProductById(id);
		
		
	}
	

}
