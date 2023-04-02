package com.flipkart.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flipkart.dao.OrderDao;
import com.flipkart.model.Order;
@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void placeOrder(Order order) {
		
		String status = "Order placed";
		
		LocalDateTime current = LocalDateTime.now();
        LocalDateTime delivery = current.plusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss");
        String currentDate = current.format(formatter);
        String deliveryDate = delivery.format(formatter);
	    
       String sql =" insert into orders ( product_id, customer_id, status, payment_mode, payment_status, created_on, updated_on, delivery_on ) value (:productId, :customerId, :status, :paymentMode, :paymentStatus, :createdOn, :updatedOn, :deliveryOn);";
	   Query query = entityManager.createNativeQuery(sql, Order.class);
	   query.setParameter("productId", order.getProductId());
	   query.setParameter("customerId", order.getCustomerId());
	   query.setParameter("status", status);
	   query.setParameter("paymentMode", order.getPaymentMode());
	   query.setParameter("paymentStatus", order.getPaymentStatus());
	   query.setParameter("createdOn", currentDate);
	   query.setParameter("updatedOn", currentDate);
	   query.setParameter("deliveryOn", deliveryDate);
	   query.executeUpdate();
	}

	
	public List<Order> getAllOrders() {

		return null;
	}

}
