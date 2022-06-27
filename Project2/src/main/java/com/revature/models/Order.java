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

<<<<<<< HEAD
import org.springframework.stereotype.Component;
@Component
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> origin/cody
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_ID;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User User;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@Column(name = "plant_name")
//	private String product_name;
//	
//	@Column(name = "subtotal")
//	private double subtotal;
//	
	@Column(name = "quantity")
	private int quantity;   ///merge orderservice and cartservice and orderdao and cartDao
//	
//
	@Column(name = "total")
	private double total;
	


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



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(User, order_ID, product, quantity, total);
	}



	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(User, other.User) && order_ID == other.order_ID && Objects.equals(product, other.product)
				&& quantity == other.quantity && Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}


	
	
	public Order(int order_ID, Product product, com.revature.models.User user, int quantity, double total) {
		super();
		this.order_ID = order_ID;
		this.product = product;
		User = user;
		this.quantity = quantity;
		this.total = total;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [order_ID=" + order_ID + ", product=" + product + ", User=" + User + ", quantity=" + quantity
				+ ", total=" + total + "]";
	}

	public void setProduct_ID(ArrayList<Integer> product_id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
