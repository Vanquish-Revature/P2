package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.controllers.AuthController;
import com.revature.controllers.UserController;
import com.revature.models.Order;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repo.OrderDAO;
import com.revature.repo.ProductDAO;

@Service

@Scope("prototype")

public class OrderService {
	
	static ArrayList<Product> cartList = new ArrayList<Product>();
	
	
	OrderDAO odao = new OrderDAO();
	private Order o;
	
//	@Autowired
//	public OrderService(Order order) {
//		this.o = order;
//	}

	public ArrayList<Product> addToCart(Product p) {
	ProductDAO pdao = new ProductDAO();
		if(pdao.getProductByName(p.getProduct_name())!=null) {
			cartList.add(p);
			System.out.println(cartList);
			return cartList;
		} else {
			System.out.println("Item not found!");
			return cartList;
		}
		
	}
	
	public ArrayList<Product> removeFromCart(Product p){
		if(p.getProduct_name()!=null && cartList!=null) {
			for(Product pro : cartList) {
				if(p.getProduct_name() == pro.getProduct_name()) {
					cartList.remove(pro);
				}
			}
			return cartList;
		} else {
			return cartList;
		}
	}

	public List<Order> getAllOrders() {
		return odao.getAllOrders();
	}
	
	public int submitOrder(Order orders) {
		return odao.submitOrder(orders);
	}

	ArrayList<Integer> product_id = new ArrayList<>();
	public int submitOrder() {
		o.setUser(UserController.ud.getUserById(1));
		for(Product product : cartList) {
			product_id.add(product.getProduct_ID());
		}
		o.setProduct_ID(product_id);
		return odao.submitOrder(o);
	}

	


	
}
