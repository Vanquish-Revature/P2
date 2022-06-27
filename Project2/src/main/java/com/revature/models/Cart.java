package com.revature.models;

import java.util.Date;
import java.util.Objects;

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
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(unique = true, nullable = false)
	private String billingInfo;
	@Column(unique = false, nullable = false)
	private List<Product> productsPurchased;
	@Column(unique = false, nullable = false)
	private int amount;
	@Column(unique = false, nullable = false)
	private double subtotal;
	@Column(unique = false, nullable = false)
	private double price;
	@Column(unique = false, nullable = false)
	private double total;
	@Column(unique = false, nullable = false)
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getId() { 
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getProductsPurchased() {
		return productsPurchased;
	}
	public void setProductsPurchased(List<Product> productsPurchased) {
		this.productsPurchased = productsPurchased;
	}
	public String getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cart() {
		super();
	}
	public Cart(int id, String billingInfo, List<Product> productsPurchased, int amount, double subtotal,
			double price, double total) {
		super();
		this.id = id;
		this.billingInfo = billingInfo;
		this.productsPurchased = productsPurchased;
		this.amount = amount;
		this.subtotal = subtotal;
		this.price = price;
		this.total = total;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", billingInfo=" + billingInfo + ", productsPurchased=" + productsPurchased
				+ ", amount=" + amount + ", subtotal=" + subtotal + ", price=" + price + ", total=" + total + "]";
	}

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
	private double totalPrice;
	
//	@CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss z", timezone="UTC")
//    @Column(name="CREATED_TS",columnDefinition = "datetime", nullable=false, updatable = false)
//	private Date createdTime;
//    
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss z", timezone="UTC")
//    @Column(name="UPDATED_TS",columnDefinition = "datetime", nullable=false, updatable = true)
//	private Date updatedTime;

   




	public int getQuantity() {
		return quantity;
	}




	public double getPrice() {
		return price;
	}





	public double getTotalPrice() {
		return totalPrice;
	}




//	public Date getCreatedTime() {
//		return createdTime;
//	}
//
//
//
//
//	public Date getUpdatedTime() {
//		return updatedTime;
//	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

//	public void setCreatedTime(Date createdTime) {
//		this.createdTime = createdTime;
//	}
//
//	public void setUpdatedTime(Date updatedTime) {
//		this.updatedTime = updatedTime;
//	}

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




	public Cart(int cartitem_ID, User user, Product product, int quantity, double price, double totalPrice) {
		super();
		this.cartitem_ID = cartitem_ID;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}




	@Override
	public int hashCode() {
		return Objects.hash(cartitem_ID, price, product, quantity, totalPrice, user);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return cartitem_ID == other.cartitem_ID
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product, other.product) && quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& Objects.equals(user, other.user);
	}




	@Override
	public String toString() {
		return "Cart [cartitem_ID=" + cartitem_ID + ", user=" + user + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}




	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	
	
	
	
	
	
	

}