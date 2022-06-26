package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.models.CartItem;
import com.revature.models.User;
import com.revature.repo.CartDAO;

@Service
public class CartService {
	
	CartDAO cartDao;
	
	@Autowired
	public CartService (CartDAO cartDAO) {
		this.cartDao =cartDAO;
	}
	
	public int addProductToCart(CartItem cartItem)
	{
		return cartDao.addProductToCart(cartItem);
	}
	
	public int deleteProductInCart(CartItem cartItem)
	{
		return cartDao.deleteProductToCart(cartItem);
	}
	
	public List<CartItem> getProductsInCart(User user)
	{
		return cartDao.getAllProductsInCart(user);
	}
	
	
	
}
