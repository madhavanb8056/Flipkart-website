package com.flipkart.services.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import com.flipkart.model.Order;
import com.flipkart.dao.OrderDao;
import com.flipkart.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao orderDao) {
          this.orderDao = orderDao;
	}
	
	
	
	public void placeOrder(Order order) {
		orderDao.placeOrder(order);
		
	}

	public List<Order> getAllOrders() {

		return null;
	}

}
