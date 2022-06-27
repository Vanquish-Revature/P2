package com.revature.controllers;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.repo.CartDAO;
import com.revature.services.CartService;




@Controller
@ResponseBody
@RequestMapping(value="/cart")
@CrossOrigin
public class CartController {

	private static Logger logger = LoggerFactory.getLogger(CartController.class);
	
	private CartService cartService;
	private CartDAO cartDAO;
	
	
	@Autowired
	public CartController(CartDAO cDAO) {
		this.cartDAO = cDAO;
	}
	
	
	@Autowired
	public void CartService(CartService cService) 
	{
		this.cartService = cService;
	}
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(Cart cartItem) {
		
		try
		{
			if(cartService.addProductToCart(cartItem)==1) {
				return ResponseEntity.status(HttpStatus.OK).body("Product added to the cart Successful!");
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Error : Product did not added to the cart");
			}
			
		} catch (Exception e) {
			logger.error("responseBody> error>>", e);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Error while processing the request.");
		}
	}
	
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Cart> updateProduct(@RequestBody Cart cartItem){ 
			try 
			{
				cartDAO.updateProductWithHQL(cartItem);
				return ResponseEntity.ok(cartItem);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cartItem);
			}
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(Cart cartItem) {
		try
		{
			if(cartService.deleteProductInCart(cartItem)==1) {
				return ResponseEntity.status(HttpStatus.OK).body("Product deleted from the cart Successful!");
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Error : Product did not deleted to the cart");
			}
			
		} catch (Exception e) {
			logger.error("responseBody> error>>", e);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Error while processing the request.");
		}
		
	}
	
	@GetMapping("/cartItems")
	public List<Cart> getProductsInCart(User user){
		return cartService.getProductsInCart(user);
	}
	
	
	
}
