package com.revature.repo;


import com.revature.models.Cart;
import com.revature.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	//Need to implement this
	public List<Cart> findCartItemsByUser(User user);

	public Cart save(Cart cart);
	
	
}
