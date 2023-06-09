package com.flipkart.services;

import java.util.List;
import java.util.Map;

import com.flipkart.dto.OrderDto;
import com.flipkart.model.Order;

public interface OrderService {

	
	public Order getOrdersByProductIdAndCustomerId(int productId, long customerId);
	public Order placeOrder(Order order);
	public List<OrderDto> getOrdersByCustomerId(long id);
	public Map<String, List<Order>> getAllOrders();
}
