package com.revature.models;

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
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private int quantity;

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public Product getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(Product product_ID) {
		this.product_ID = product_ID;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_ID, price, product_ID, product_name, quantity, user_ID);
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
		return order_ID == other.order_ID && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& product_ID == other.product_ID && Objects.equals(product_name, other.product_name)
				&& quantity == other.quantity && user_ID == other.user_ID;
	}

	@Override
	public String toString() {
		return "Order [order_ID=" + order_ID + ", product_ID=" + product_ID + ", user_ID=" + user_ID + ", product_name="
				+ product_name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	public Order(int order_ID, Product product_ID, User user_ID, String product_name, double price, int quantity) {
		super();
		this.order_ID = order_ID;
		this.product_ID = product_ID;
		this.user_ID = user_ID;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
