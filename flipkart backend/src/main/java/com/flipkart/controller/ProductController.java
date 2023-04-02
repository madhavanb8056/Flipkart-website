package com.flipkart.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.model.Catagory;
import com.flipkart.model.Customer;
import com.flipkart.model.Product;
import com.flipkart.services.ProductService;


@RestController
@RequestMapping("/api/product")
@CrossOrigin	
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	private ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		if(!CollectionUtils.isEmpty(products)) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping(path = "/catagory")
	private ResponseEntity<List<Catagory>> getAllcatagories() {
		List<Catagory> catagory= productService.getAllCatagories();
		if(!CollectionUtils.isEmpty(catagory)) {
			return new ResponseEntity<>(catagory, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(catagory, HttpStatus.NO_CONTENT);
		}
    }
	
	@GetMapping(path = "/catagory/{id}")
	public ResponseEntity<List<Product>> getProductsByCatagoryId(@PathVariable(name = "id") int id) {
		List<Product> products = productService.getProductsByCatagoryId(id);
		if(!CollectionUtils.isEmpty(products)) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(path = "/search/{search}")
	public ResponseEntity<List<Product>> searchProduct(@PathVariable(name = "search") String search) {
            List<Product> products = productService.searchProducts(search);
            if(!CollectionUtils.isEmpty(products)) {
    			return new ResponseEntity<>(products, HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
    		}
	}
	
	
	
	
	 
}
