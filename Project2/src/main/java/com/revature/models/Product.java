package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
=======
import javax.persistence.Lob;
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
import javax.persistence.Table;

@Entity
@Table(name ="product")

	
public class Product {
	
//	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	//@JoinColumn(name = "user_id") //This is how we establish a foreign key relationship with another table

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_ID;
<<<<<<< HEAD
	@Column(nullable = false, unique = true, name = "plant_name") //unique constraint
	private String product_name;
=======
	@Column(name = "plant_name")
	private String product_name;
//	@Lob
//	@Column(columnDefinition="MEDIUMBLOB")
//	private String image;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
	private double price;
	private int quantity;
	
<<<<<<< HEAD
=======
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
	
//	public String getImage() {
//		return image;
//	}
//	public void setImage(String image) {
//		this.image = image;
//	}
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_ID, String product_name, double price, int quantity) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
<<<<<<< HEAD
=======
		this.description = description;
//		this.image = image;
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
		this.price = price;
		this.quantity = quantity;
	}

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

	@Override
	public String toString() {
		return "Product [product_ID=" + product_ID + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, product_ID, product_name, quantity);
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
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && product_ID == other.product_ID
				&& Objects.equals(product_name, other.product_name) && quantity == other.quantity;
	}

	
}
