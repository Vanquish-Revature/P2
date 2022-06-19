package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.services.CartService;
import com.revature.utilities.JsonResponse;



@Controller
@RequestMapping(value = "/cart")
public class CartController {

	private static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;
	 
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
    public @ResponseBody JsonResponse addProductToCart(@RequestBody Cart cartItem)
	{
		JsonResponse respone = new JsonResponse();
		try
		{
			logger.info("Inside '/addProduct' request");
			Cart addedCart = cartService.addProductToCart(cartItem);
			respone.setStatus("Success");
			respone.setResult(addedCart);
		} catch (Exception e) {
			logger.error("responseBody> error>>", e);
			respone.setStatus("FAILED");
		}
		
		return respone;
	}
	
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
    public @ResponseBody JsonResponse updateProductToCart(@RequestBody Cart cartItem)
	{
		JsonResponse respone = new JsonResponse();
		try
		{
			int cartItem_ID = cartItem.getCartitem_ID();
			
			Cart existingCartItem = cartService.getCartItem(cartItem_ID);
			
			if(existingCartItem !=null)
			{
				existingCartItem.setCartitem_ID(cartItem_ID);
				existingCartItem.setDiscount(cartItem.getDiscount());
				existingCartItem.setPrice(cartItem.getPrice());
				existingCartItem.setProduct(cartItem.getProduct());
				existingCartItem.setQuantity(cartItem.getQuantity());
				existingCartItem.setTotalPrice(cartItem.getTotalPrice());
				//existingCartItem.setUpdatedTime();
				existingCartItem.setUser(cartItem.getUser());
				
			}
			
			
			logger.info("Inside '/updateProduct' request");
			Cart addedCart = cartService.updateProductInCart(existingCartItem);
			respone.setStatus("Success");
			respone.setResult(addedCart);
		} catch (Exception e) {
			logger.error("responseBody> error>>", e);
			respone.setStatus("FAILED");
		}
		return respone;
	}
	
	@RequestMapping(value="/deleteProduct",method=RequestMethod.POST)
    public @ResponseBody JsonResponse deleteProductToCart(@RequestBody Cart cartItem)
	{
		
		JsonResponse respone = new JsonResponse();
		try
		{
			logger.info("Inside '/deleteProduct' request");
			cartService.deleteProductInCart(cartItem);
			respone.setStatus("Success");
			
		} catch (Exception e) {
			logger.error("responseBody> error>>", e);
			respone.setStatus("FAILED");
		}
		return respone;
	}
	
	
	@RequestMapping(value="/cartItems",method=RequestMethod.GET)
    public @ResponseBody JsonResponse productsInCart(User user)
	{
		logger.info("Inside '/cartItems' request");
		JsonResponse respone = new JsonResponse();
		
		List<Cart> cartItems = cartService.getProductsInCart(user);
		
		respone.setStatus("Success");
		respone.setResult(cartItems);
		return respone;
	}
	
	
	
}
