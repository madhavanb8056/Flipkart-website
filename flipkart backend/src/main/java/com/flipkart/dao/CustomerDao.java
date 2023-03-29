package com.flipkart.dao;

import com.flipkart.model.Customer;

public interface CustomerDao {
	
	public Customer getCustomerByPhnNumAndPassword(Long phnNum, String password);
	
	public void createNewCustomer(Customer customer);

	
}
