package com.flipkart.services.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import com.flipkart.model.Order;
import com.flipkart.model.Product;
import com.flipkart.dao.OrderDao;
import com.flipkart.dto.OrderDto;
import com.flipkart.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao orderDao) {
          this.orderDao = orderDao;
	}
	
	
	
	public Order placeOrder(Order order) {
		return orderDao.placeOrder(order);
		
	}
	public List<OrderDto> getOrdersByCustomerId(long id){
		
		return orderDao.getOrdersByCustomerId(id);
	}

	public Order getOrdersByProductIdAndCustomerId(int productId, long customerId) {

		return orderDao.getOrdersByProductIdAndCustomerId(productId, customerId);
	}

}
