package com.revature.models;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_ID;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Product_ID")
	private Product product_ID;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user_ID;
	
	@Column(nullable = false, unique = true, name = "plant_name")
	private String product_name;
	
	@Column(name = "subtotal")
	private double subtotal;
	
	@Column(name = "quantity")
	private int quantity;   ///merge orderservice and cartservice and orderdao and cartDao
	

	@Column(name = "total")
	private double total;
	
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public Product getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(Product product_id) {
		this.product_ID = product_id;
	}

	public User getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(User user_ID) {
		this.user_ID = user_ID;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_ID, subtotal, product_ID, product_name, quantity, user_ID, total);
	}



	public Order(int order_ID, Product product_ID, User user_ID, String product_name, double subtotal, int quantity,
			double total) {
		super();
		this.order_ID = order_ID;
		this.product_ID = product_ID;
		this.user_ID = user_ID;
		this.product_name = product_name;
		this.subtotal = subtotal;
		this.quantity = quantity;
		this.total = total;
	}
	
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [order_ID=" + order_ID + ", product_ID=" + product_ID + ", user_ID=" + user_ID + ", product_name="
				+ product_name + ", subtotal=" + subtotal + ", quantity=" + quantity + ", total=" + total + "]";
	}

	public void setProduct_ID(ArrayList<Integer> product_id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
