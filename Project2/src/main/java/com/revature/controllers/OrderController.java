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
import com.revature.repo.ProductDAO;
import com.revature.services.OrderService;


@Controller
@ResponseBody
@RequestMapping(value="/order")
@CrossOrigin
public class OrderController {
	ArrayList<Product> cart;
	
	OrderService oService = new OrderService();

	
	@Autowired
	public OrderController(OrderService os) {
		this.oService = os;
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		return oService.getAllOrders();
	}
	
	
	@PostMapping("/checkout")
	public ResponseEntity<String> submitOrder(@RequestBody Order orders) {
		try {
		oService.submitOrder(orders);
			return ResponseEntity.ok("Order submitted");
		}
		catch(Exception e) {
	return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order error");
	}
	
}



	@PutMapping("/addToCart")
	public ArrayList<Product> addToCart(Product p) {
		ProductDAO pd = new ProductDAO();
		if(pd.getProductByName(p.getProduct_name())!=null) {
			cart.add(p);
			System.out.println(cart);
			return cart;
		} else {
			System.out.println("item not found");
			return cart;
		
		}
	}

}

