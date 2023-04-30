package com.flipkart.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.flipkart.model.Order;
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
    
	public Map<String, List<Order>> getAllOrders(){
		List<Order> li = orderDao.getAllOrders();
	    Map<String, List<Order>> map = new HashMap<>();
	    
	    for(Order or: li) {
	    	
	    	String x =or.getPaymentStatus();
	    	if (map.get(x) != null) {
			      List<Order> pre = map.get(or.getPaymentStatus());
			      pre.add(or);
			      map.put(or.getPaymentStatus(), pre);
			   
	    	
	   }else {
		   List<Order> temp = new ArrayList<>();
	    	temp.add(or);
	    	map.put(or.getPaymentStatus(), temp);
	}
		
	}return map;

}
	
}