package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.context.annotation.Scope;
=======
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
import org.springframework.stereotype.Service;

import com.revature.models.Product;
import com.revature.repo.ProductDAO;

@Service
<<<<<<< HEAD
@Scope("prototype")
public class ProductService {

	private ProductDAO pd;
		
	@Autowired
	public ProductService (ProductDAO pDAO) {
		this.pd =pDAO;
	}
	
	public Product getProductByName (String product_name) {
		
=======
public class ProductService {

		ProductDAO pd = new ProductDAO();
		
//	@Autowired
//	public ProductService (ProductDAO pDAO) {
//		this.pd =pDAO;
//	}
	
	public List<Product> getProductByName (String product_name) {
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
		return pd.getProductByName(product_name);
	
	}
	public Product getProductById(int product_ID) {
		return pd.getProductById(product_ID);
			
	}
	public List<Product> getAllProducts(){
		return pd.getAllProduct();
	
	}
	
<<<<<<< HEAD
	public static void addProduct(Product product) {
		ProductDAO.insertProduct(product); 
}
=======
//	public static void addProduct(Product product) {
//		return pd.insertProduct(product); 
//}
>>>>>>> 0c297824bd2937f2e378cfb1c61c9235b49ff66e
	
	}
