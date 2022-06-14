package com.revature.repo;


import com.revature.models.CartItem;
import com.revature.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAOImpl extends JpaRepository<CartItem, Integer> {
	
	//Need to implement this
	public List<CartItem> findCartItemsByUser(User user);
	
	
}
