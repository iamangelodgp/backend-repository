package com.accenture.ws.entity;

import java.util.List;

public class OrderBill {
	
	private List<Order> orderList;
	private CafeClerk clerk;
	
	
	public OrderBill(CafeClerk clerk) {
		this.clerk = clerk;
	}
	
	public CafeClerk getClerk() {
		return clerk;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	
//	public double getTotalBill() {
//		return 
//		
//	}
//	
	
	
 
}
