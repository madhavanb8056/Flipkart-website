package com.flipkart.services.impl;


import java.util.Objects;

import org.springframework.stereotype.Service;

import com.flipkart.dao.CustomerDao;
import com.flipkart.model.Customer;
import com.flipkart.services.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public Customer getCustomer(Long phn, String password) {
		
		Customer customer = customerDao.getCustomerByPhnNumAndPassword(phn, password);
		
		if(Objects.nonNull(customer)) {
			return customer;
		}
		return null;
	}

}
