package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Product;
import com.revature.repo.ProductDAO;

@Service
public class ProductService {

		ProductDAO pd = new ProductDAO();
		
//	@Autowired
//	public ProductService (ProductDAO pDAO) {
//		this.pd =pDAO;
//	}
	
	public List<Product> getProductByName (String product_name) {
		return pd.getProductByName(product_name);
	
	}
	public Product getProductById(int product_ID) {
		return pd.getProductById(product_ID);
			
	}
	public List<Product> getAllProducts(){
		return pd.getAllProduct();
	
	}
	
//	public static void addProduct(Product product) {
//		return pd.insertProduct(product); 
//}
	
	}
