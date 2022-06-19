package com.revature.models;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private String billingInfo;
	@Column(unique = false, nullable = false)
//	private List<Product> productsPurchased;
//	@Column(unique = false, nullable = false)
	private int amount;
	@Column(unique = false, nullable = false)
	private double subtotal;
	@Column(unique = false, nullable = false)
	private double discount;
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
//	public List<Product> getProductsPurchased() {
//		return productsPurchased;
//	}
//	public void setProductsPurchased(List<Product> productsPurchased) {
//		this.productsPurchased = productsPurchased;
//	}
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
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
			double discount, double total) {
		super();
		this.id = id;
		this.billingInfo = billingInfo;
//		this.productsPurchased = productsPurchased;
		this.amount = amount;
		this.subtotal = subtotal;
		this.discount = discount;
		this.total = total;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", billingInfo=" + billingInfo + ", productsPurchased=" + 
				 ", amount=" + amount + ", subtotal=" + subtotal + ", discount=" + discount + ", total=" + total + "]";
	}
	

}
