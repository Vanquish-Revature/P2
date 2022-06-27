
<<<<<<< HEAD
//package com.revature.controllers;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.revature.models.Cart;
//import com.revature.models.User;
//import com.revature.services.CartService;
//import com.revature.utilities.JsonResponse;
//
//@Controller
//@ResponseBody
//@CrossOrigin
//@RequestMapping(value = "/cart")
//public class CartController {
//	
//		private static Logger logger = LoggerFactory.getLogger(CartController.class);
//
//		private CartService cartService;
//		@Autowired 
//		public  CartController(CartService ds) {
//			this.cartService=ds;
//		}
//		//CartService cartService;
//		 
//		@RequestMapping(value="/addProduct",method=RequestMethod.POST)
//	    public @ResponseBody JsonResponse addProductToCart(@RequestBody Cart cartItem)
//		{
//			JsonResponse respone = new JsonResponse();
//			try
//			{
//				logger.info("Inside '/addProduct' request");
//				Cart addedCart = cartService.addProductToCart(cartItem);
//				respone.setStatus("Success");
//				respone.setResult(addedCart);
//			} catch (Exception e) {
//				logger.error("responseBody> error>>", e);
//				respone.setStatus("FAILED");
//			}
//			
//			return respone;
//		}
//		
//		
//		@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
//	    public @ResponseBody JsonResponse updateProductToCart(@RequestBody Cart cartItem)
//		{
//			JsonResponse respone = new JsonResponse();
//			try
//			{
//				int cartItem_ID = cartItem.getId();
//				
//				Cart existingCartItem = cartService.getCartItem(cartItem_ID);
//				
//				if(existingCartItem !=null)
//				{
//					existingCartItem.setId(cartItem_ID);
//					existingCartItem.setPrice(cartItem.getPrice());
//					existingCartItem.setProductsPurchased(cartItem.getProductsPurchased());
//					existingCartItem.setAmount(cartItem.getAmount());
//					existingCartItem.setTotal(cartItem.getTotal());
//					//existingCartItem.setUpdatedTime();
////					existingCartItem.setUser(cartItem.getUser());
//					
//				}
//				
//				
//				logger.info("Inside '/updateProduct' request");
//				Cart addedCart = cartService.updateProductInCart(existingCartItem);
//				respone.setStatus("Success");
//				respone.setResult(addedCart);
//			} catch (Exception e) {
//				logger.error("responseBody> error>>", e);
//				respone.setStatus("FAILED");
//			}
//			return respone;
//		}
//		
//		@RequestMapping(value="/deleteProduct",method=RequestMethod.POST)
//	    public @ResponseBody JsonResponse deleteProductToCart(@RequestBody Cart cartItem)
//		{
//			
//			JsonResponse respone = new JsonResponse();
//			try
//			{
//				logger.info("Inside '/deleteProduct' request");
//				cartService.deleteProductInCart(cartItem);
//				respone.setStatus("Success");
//				
//			} catch (Exception e) {
//				logger.error("responseBody> error>>", e);
//				respone.setStatus("FAILED");
//			}
//			return respone;
//		}
//		
//		
//		@RequestMapping(value="/cartItems",method=RequestMethod.GET)
//	    public @ResponseBody JsonResponse productsInCart(User user)
//		{
//			logger.info("Inside '/cartItems' request");
//			JsonResponse respone = new JsonResponse();
//			
//			List<Cart> cartItems = cartService.getProductsInCart(user);
//			
//			respone.setStatus("Success");
//			respone.setResult(cartItems);
//			return respone;
//		}
//		
//		
//		
//
//}


=======
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
	

	CartDAO cartDAO = new CartDAO();
	
	CartService cartService = new CartService(cartDAO);
	
	
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
>>>>>>> origin/cody
