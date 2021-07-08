package com.accenture.ws.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.ws.entity.OrderClass;
import com.accenture.ws.repository.OrderRepo;

@Service
public class OrderService {
	
	private final OrderRepo orderRepo;

	public OrderService(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public List<OrderClass> findAllOrders() {
		return orderRepo.findAll();
	}
	
	public OrderClass addOrder( OrderClass orderClass) {
		return orderRepo.save(orderClass);
	}
	
	
	
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
		
	}
	
	public OrderClass findSingleOrder(Long id) {
		return orderRepo.findOrderById(id);
	}
	
	public OrderClass updateOrder(Long id,OrderClass orderClass){
		OrderClass existingOrder = orderRepo.findOrderById(id);
		if (existingOrder.getIsDiscounted() == false) {
			existingOrder.setIsDiscounted(orderClass.getIsDiscounted());
			existingOrder.setPrice(existingOrder.getPrice()*existingOrder.getIsDiscountPercentage());
			return orderRepo.save(existingOrder);
		}
		existingOrder.setIsDiscounted(orderClass.getIsDiscounted());
		if (existingOrder.getPrice() < existingOrder.getOriginalPrice()) {
			existingOrder.setPrice(existingOrder.getOriginalPrice());
		}
		return orderRepo.save(existingOrder);	
		
		
	}
	
}
