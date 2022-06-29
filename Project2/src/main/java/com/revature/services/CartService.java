package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.repo.CartDAO;

@Service
public class CartService {
	
	CartDAO cartDao;
	
	@Autowired
	public CartService (CartDAO cartDAO) {
		this.cartDao =cartDAO;
	}
	
	public int addProductToCart(Cart cartItem)
	{
		return cartDao.addProductToCart(cartItem);
	}
	
	public int deleteProductInCart(Cart cartItem)
	{
		return cartDao.deleteProductToCart(cartItem);
	}
	
	public List<Cart> getProductsInCart(User user)
	{
		return cartDao.getAllProductsInCart(user);
	}
	
	
	
}
