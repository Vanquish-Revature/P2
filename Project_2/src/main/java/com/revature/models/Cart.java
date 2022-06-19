package com.revature.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Cart_Item")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CartItem_ID")
	private int cartitem_ID;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double discount;
	
	@Column(nullable = false)
	private double totalPrice;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss z", timezone="UTC")
    @Column(name="CREATED_TS",columnDefinition = "datetime", nullable=false, updatable = false)
	private Date createdTime;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss z", timezone="UTC")
    @Column(name="UPDATED_TS",columnDefinition = "datetime", nullable=false, updatable = true)
	private Date updatedTime;

   




	public int getQuantity() {
		return quantity;
	}




	public double getPrice() {
		return price;
	}




	public double getDiscount() {
		return discount;
	}




	public double getTotalPrice() {
		return totalPrice;
	}




	public Date getCreatedTime() {
		return createdTime;
	}




	public Date getUpdatedTime() {
		return updatedTime;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getCartitem_ID() {
		return cartitem_ID;
	}

	public User getUser() {
		return user;
	}




	public Product getProduct() {
		return product;
	}




	public void setCartitem_ID(int cartitem_ID) {
		this.cartitem_ID = cartitem_ID;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public void setProduct(Product product) {
		this.product = product;
	}



	
	
	
	
	
	
	
	
	

}
