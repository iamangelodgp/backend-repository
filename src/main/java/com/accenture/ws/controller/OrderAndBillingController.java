package com.accenture.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.repository.OrderRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderAndBillingController {
	
	@Autowired
	private OrderRepository orderRepo;
	//private CafeClerk clerk;
	
	public OrderAndBillingController() {
	}
	
	@GetMapping("/orders")
	public List<Order> getOrderList() {
		return orderRepo.findAll();
		
	}
	
	@PostMapping("/orders")
	public void addOrder(@RequestBody Order order) {
		
		order.setId((long) 0);
		orderRepo.save(order);
		
	}
	
	@PutMapping("/orders")
	public void updateOrder(@RequestBody Order order) {
		
		orderRepo.save(order);
		
	}
	
	@DeleteMapping("/orders")
	public void deleteOrder(@RequestBody Order order) {
		orderRepo.delete(order);
	}
	
	public OrderBill getTotalRegularBill() {
		return null;
		
	}
	
	public OrderBill getTotalDiscountedBill() {
		return null;
		
	}
	
	

}
