package com.revature.models;

public class Product {
	private int product_ID;
	private String product_name;
	private String description;
	private double price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Product(int product_ID, String product_name, String description, double price, int quantity) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [product_ID=" + product_ID + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + "]";
	} 
	
}
