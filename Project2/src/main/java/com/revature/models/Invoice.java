package com.revature.models;

import java.util.List;
public class Invoice {
	private int id;
	private String billingInfo;
	public List<Product> productsPurchased;
	private double subtotal;
	private double discount;
	private double total;
	
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
	public Invoice() {
		super();
	}
	public Invoice(int id, String billingInfo, List<Product> productsPurchased, double subtotal, double discount,
			double total) {
		super();
		this.id = id;
		this.billingInfo = billingInfo;
		this.productsPurchased = productsPurchased;
		this.subtotal = subtotal;
		this.discount = discount;
		this.total = total;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", billingInfo=" + billingInfo + ", productsPurchased=" + productsPurchased
				+ ", subtotal=" + subtotal + ", discount=" + discount + ", total=" + total + "]";
	}

}
