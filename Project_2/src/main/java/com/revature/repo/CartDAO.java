package com.revature.repo;


import com.revature.models.Cart;
import com.revature.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	//Need to implement this
	public List<Cart> findCartItemsByUser(User user);
	
	
}
