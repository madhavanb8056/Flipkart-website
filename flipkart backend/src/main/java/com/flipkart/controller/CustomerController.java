package com.flipkart.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.model.Customer;
import com.flipkart.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {	
    
	private CustomerService customerService;  
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@GetMapping
	private ResponseEntity<Customer> getCustomerForLogin(@RequestParam(name="phnNum") Long phnNum, 
			@RequestParam(name="password") String password) {
        
		Customer customer = customerService.getCustomer(phnNum, password);
		if(Objects.nonNull(customer)) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(customer, HttpStatus.NO_CONTENT);
		}
	}
	
	
	
}