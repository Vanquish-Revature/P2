package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CartItem;
import com.revature.models.User;
import com.revature.repo.CartDAO;

@Service
public class CartService {
	
	@Autowired
	CartDAO cartDao;
	
	public CartItem addProductToCart(CartItem cartItem)
	{
		return cartDao.save(cartItem);
	}
	
	
	public CartItem updateProductInCart(CartItem cartItem)
	{
		return cartDao.save(cartItem);
	}
	
	
	public void deleteProductInCart(CartItem cartItem)
	{
		cartDao.delete(cartItem);
		return;
	}
	
	public List<CartItem> getProductsInCart(User user)
	{
		return cartDao.findCartItemsByUser(user);
	}
	
	public CartItem getCartItem(int cartItem_id)
	{
		
		
		Optional<CartItem> cartItemOptional = cartDao.findById(cartItem_id);
		if (cartItemOptional.isPresent()) {
		    return cartItemOptional.get();
		} else {
			return null;
		}
	}
	
}
