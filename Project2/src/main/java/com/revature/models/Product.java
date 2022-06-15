package com.revature.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//@Entity
//@Table(name = "product")
//public class Product {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Product_ID")
//	private int product_ID;
//	@Column(unique = true, nullable = false)
//	private String product_name;
//	@Column(nullable = false)
//	private String description;
//	@Column(nullable = false)
	
//@Entity
//@Table(name ="product")
//public class Product {
//	
////	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////	//@JoinColumn(name = "user_id") //This is how we establish a foreign key relationship with another table
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int product_ID;
//	@Column(nullable = false, unique = true, name = "plant_name") //unique constraint
//	private String product_name;
//	private double price;
//	@Column(nullable = false)
//	private int quantity;
//	
	@Entity
	@Table(name = "product")
	public class Product 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Product_ID")
		private int product_ID;
		@Column(unique = true, nullable = false)
		private String product_name;
		private double price;
//		@Column(nullable = false)
//		private String description;
		@Column(nullable = false)
		private int quantity;
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
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
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_ID, String product_name, double price, int quantity) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}

//	public int getProduct_ID() {
////		return product_ID;
//	}
//
//	public void setProduct_ID(int product_ID) {
//		this.product_ID = product_ID;
//	}
//
//	public String getProduct_name() {
//		return product_name;
//	}
//
//	public void setProduct_name(String product_name) {
//		this.product_name = product_name;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	@Override
//	public String toString() {
//		return "Product [product_ID=" + product_ID + ", product_name=" + product_name + ", price=" + price
//				+ ", quantity=" + quantity + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(price, product_ID, product_name, quantity);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && product_ID == other.product_ID
//				&& Objects.equals(product_name, other.product_name) && quantity == other.quantity;
//	}
//
//	
	
}