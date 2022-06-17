package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Order;
import com.revature.models.Product;
import com.revature.repo.OrderDAO;
import com.revature.services.OrderService;


@Controller
@ResponseBody
@RequestMapping(value="/order")
@CrossOrigin
public class OrderController {
	ArrayList<Product> cart;
	private OrderService oService;
	
	@Autowired
	public OrderController(OrderService os) {
		this.oService = os;
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		return oService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getbyId(@PathVariable("id") int id){
		Order o = oService.getOrderById(id);
		if(o == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(o);
		} else {
			return ResponseEntity.ok(o);
		}
	}
	
//	@PutMapping
//	public ResponseEntity<ArrayList<Product>> addToCart(@RequestBody Product p) {
//		if(p.getProduct_name()==null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cart);
//		} else {
//			cart = oService.addToCart(p);
//			return ResponseEntity.status(202).body(cart);
//		}
//	}
	
	@PostMapping
	public ResponseEntity<String> submitOrder(Order orders) {
		if(oService.submitOrder(null)==1) {
			return ResponseEntity.status(HttpStatus.OK).body("Checkout Successful!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Checkout Unsuccessful!");
		}
	}
	
	
}
