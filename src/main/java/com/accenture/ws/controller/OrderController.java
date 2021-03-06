package com.accenture.ws.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.ws.entity.OrderClass;
import com.accenture.ws.repository.OrderRepo;
import com.accenture.ws.impl.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("orders")
public class OrderController {
	
	
	private final OrderService orderService;
	

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderClass>> getAllProducts() {
		List<OrderClass> users = orderService.findAllOrders();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<OrderClass> addOrderController(@RequestBody OrderClass order){
		OrderClass newOrder = orderService.addOrder(order);
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrderController(@PathVariable("id") Long id){
		orderService.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderClass> getOneOrder(@PathVariable("id") Long id) {
		OrderClass neworder = orderService.findSingleOrder(id);
		return new ResponseEntity<>(neworder,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<OrderClass> getOneOrderandUpdate(@PathVariable("id") Long id,@RequestBody OrderClass order) {
		OrderClass neworder = orderService.updateOrder(id,order);
		return new ResponseEntity<>(neworder,HttpStatus.OK);
	} 
}