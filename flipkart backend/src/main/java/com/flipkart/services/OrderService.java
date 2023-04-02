package com.flipkart.services;

import java.util.List;

import com.flipkart.model.Order;

public interface OrderService {

	
	public List<Order> getAllOrders();
	public void placeOrder(Order order);

}
