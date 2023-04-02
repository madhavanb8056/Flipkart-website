package com.flipkart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.model.Order;
import com.flipkart.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
          this.orderService = orderService;
}
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return null;
		
	}
	@PostMapping(path = "/create")
	private ResponseEntity<Object> placeOrder(@RequestBody Order order) {
		orderService.placeOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);

	}
	
	
	

}
