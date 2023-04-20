package com.flipkart.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.dto.OrderDto;
import com.flipkart.model.Order;
import com.flipkart.services.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
	
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
          this.orderService = orderService;
}
	@GetMapping
	public ResponseEntity<Order> getOrdersByProductIdAndCustomerId(@RequestParam(name="productId") int productId, 
			@RequestParam(name="customerId") long customerId) {
	    Order Order = orderService.getOrdersByProductIdAndCustomerId(productId, customerId);
	    if(Objects.nonNull(Order)) {
			return new ResponseEntity<>(Order, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Order, HttpStatus.NO_CONTENT);
		}
}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Object> placeOrder(@RequestBody Order order) {
		orderService.placeOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable(name = "id") int id) {
		List<OrderDto> orders = orderService.getOrdersByCustomerId(id);
		if(!CollectionUtils.isEmpty(orders)) {
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(orders, HttpStatus.NO_CONTENT);
		}

		
	}

}
