
//package com.revature.services;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.revature.models.Cart;
//import com.revature.models.User;
//import com.revature.repo.CartDAO;
//@Service
//public class CartService {
//	@Autowired
//	CartDAO cartDao;
//	
//	public Cart addProductToCart(Cart cartItem)
//	{
//		return cartDao.save(cartItem);
//	}
//	
//	
//	public Cart updateProductInCart(Cart cartItem)
//	{
//		return cartDao.save(cartItem);
//	}
//	
//	
//	public void deleteProductInCart(Cart cartItem)
//	{
//		cartDao.delete(cartItem);
//		return;
//	}
//	
//	public List<Cart> getProductsInCart(User user)
//	{
//		return cartDao.findCartItemsByUser(user);
//	}
//	
//	public Cart getCartItem(int cartItem_id)
//	{
//		Optional<Cart> cartItemOptional = cartDao.findById(cartItem_id);
//		if (cartItemOptional.isPresent()) {
//		    return cartItemOptional.get();
//		} else {
//			return null;
//		}
//	}
//}

