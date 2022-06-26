package com.revature.repo;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.CartItem;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

@Repository

public class CartDAO {
	
	public int addProductToCart(CartItem cartItem) {
		Session ses = HibernateUtil.getSession();
		ses.save(cartItem);
		HibernateUtil.closeSession();
		return 1;
	}
	
	//We will use HQL to update
	public void updateProductWithHQL(CartItem cartItem) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Transaction tran = ses.beginTransaction(); //ALL and I do mean ALL update and delete methods MUST happen within a transaction
		Query q = ses.createQuery("UPDATE Cart_Item SET quantity = '" + cartItem.getQuantity() + "' WHERE CartItem_ID = " + cartItem.getCartitem_ID());
		//This is what that string looks like when data is given "UPDATE Movie SET title = 'New Movie Title' Where id = 2"
		q.executeUpdate();
		tran.commit(); //This will commit the transaction if it did not encounter a problem
		HibernateUtil.closeSession(); //closes the session
	}
			
	public int deleteProductToCart(CartItem cartItem) {
		Session ses = HibernateUtil.getSession();
		ses.delete(cartItem);
		HibernateUtil.closeSession();
		return 1;
	}
	
	
	public List<CartItem> getAllProductsInCart(User user) {
		Session ses = HibernateUtil.getSession();
		List<CartItem> itemsList = ses.createQuery("FROM Cart_Item  WHERE user_id = " + user.getUser_ID()).list();
		HibernateUtil.closeSession();
		return itemsList;
	}
	
	
	
}

