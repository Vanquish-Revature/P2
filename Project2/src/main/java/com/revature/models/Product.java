package com.revature.models;

import java.util.Arrays;
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

import javax.persistence.Lob;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="product")
	
public class Product {
	
//	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	//@JoinColumn(name = "user_id") //This is how we establish a foreign key relationship with another table

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_ID;
	@Column(name = "plant_name")
	private String product_name;
//	@Lob
//	private byte[] image;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
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
	
//	public byte[] getImage() {
//		return image;
//	}
//	public byte[] setImage(byte[] image) {
//		return this.image = image;
//	}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_ID;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product_ID != other.product_ID)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	
}
