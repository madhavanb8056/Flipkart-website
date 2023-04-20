package com.flipkart.dao;

import java.util.List;

import com.flipkart.dto.OrderDto;
import com.flipkart.model.Order;

public interface OrderDao {
	public Order getOrdersByProductIdAndCustomerId(int productId, long customerId);
	public Order placeOrder(Order order);
	public List<OrderDto> getOrdersByCustomerId(long id);

}
