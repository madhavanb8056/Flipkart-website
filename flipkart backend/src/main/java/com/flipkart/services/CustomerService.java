package com.flipkart.services;


import com.flipkart.model.Customer;

public interface CustomerService {

	public Customer getCustomer(Long phn, String password);
	

}
