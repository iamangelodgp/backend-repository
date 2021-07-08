package com.accenture.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.ws.entity.OrderClass;

public interface OrderRepo extends JpaRepository<OrderClass, Long> {
	
	
	
	public OrderClass findOrderById (Long id);
	
}
