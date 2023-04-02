package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Order;

public interface OrderDao {
    public List<Order> getAllOrders();
	public void placeOrder(Order order);
	

}
