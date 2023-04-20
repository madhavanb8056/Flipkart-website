package com.flipkart.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flipkart.dao.OrderDao;
import com.flipkart.dto.OrderDto;
import com.flipkart.model.Order;
@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Order placeOrder(Order order) {
		
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
	   return getOrdersByProductIdAndCustomerId(order.getProductId(), order.getCustomerId());
	}

	@Transactional
	public Order getOrdersByProductIdAndCustomerId(int productId, long customerId) {
          String sql = "select * from orders  where product_id = "+productId+" and customer_id = "+customerId+" order by id desc limit 1";
          Query query = entityManager.createNativeQuery(sql, Order.class);

          try {
              return (Order) query.getSingleResult();
          } catch (NoResultException ex) {
              return null;
          }
		
	}
	
	public List<OrderDto> getOrdersByCustomerId(long id){
		String sql = "select o.id as orderId, p.product_name as productName, p.prize as prize, o.payment_mode as paymentMode, o.payment_status as paymentStatus, o.created_on as createdOn, o.delivery_on as deliveryOn, o.status as status, p.image as image from orders o left join products p on o.product_id = p.id where o.customer_id ="+id;
		Query query = entityManager.createNativeQuery(sql);
		List resultList = query.getResultList();
	    List<OrderDto> li = new ArrayList<OrderDto>();
	    for (int i= 0; i < resultList.size(); i++) {
		  	OrderDto dto = new OrderDto();
		  	Object[] obj = (Object[]) resultList.get(i);
		  	dto.setOrderId(Integer.parseInt(obj[0]+""));
		  	dto.setProductName(obj[1]+"");
		  	dto.setPrize(Integer.parseInt(obj[2]+""));
		  	dto.setPaymentMode(obj[3]+"");
		  	dto.setPaymentStatus(obj[4]+"");
		  	dto.setCreatedOn(obj[5]+"");
		  	dto.setDeliveryOn(obj[6]+"");
		  	dto.setStatus(obj[7]+"");
		  	dto.setImage(obj[8]+"");
		  	li.add(dto);
		}
	    return li;
		
		
	}

} 
