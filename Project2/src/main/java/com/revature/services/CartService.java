<<<<<<< HEAD

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

=======
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
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
