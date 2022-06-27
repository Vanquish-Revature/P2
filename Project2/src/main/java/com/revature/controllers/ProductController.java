package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Product;
import com.revature.repo.ProductDAO;
import com.revature.services.ProductService;


@Controller
@ResponseBody
@RequestMapping(value="/product")
@CrossOrigin
public class ProductController {
	
	//get by Id, get by name, insert, update, get all 
	
	public static ProductService ps;
	private ProductDAO pd;
	
	@Autowired //This annotation we are now using constructor injection to inject ProductDAO as a dependency 
	//This is our constructor that will allow us to use constructor injection and our DAO methods
	public ProductController(ProductDAO dao) {
		this.pd = dao;
	}
	
	@Autowired
	public void Productservice(ProductService prs) 
	{
		this.ps = prs;
	}
	
	@RequestMapping(method=RequestMethod.GET) 
	public List<Product> getAllProduct(){
		return pd.getAllProduct(); 
	}
	
	@GetMapping("/productID/{product_ID}")
	public ResponseEntity<Product> getByProductId(@PathVariable("product_ID") int product_ID){
		Product a = pd.getProductById(product_ID);
		
		if(a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
			
		} else {
			return ResponseEntity.ok(a);
		}
	}
	
	
	@GetMapping("/ProductName")
	public ResponseEntity<List<Product>> getByProductName(@PathVariable("product") String product_name){
		List<Product> b = pd.getProductByName(product_name);
		
		if(b == null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(b);
		}
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<Product> insertProduct(@PathVariable("product")Product product){
		try {
			pd.insertProduct(product);
			return ResponseEntity.ok(product);
		} catch(Exception e) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(product);
		}
	}
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@PathVariable("product")Product product, String product_name, double price, int quantity){ 
			try {
				pd.updateProductWithSessionMethod(product) ;
				return ResponseEntity.ok(product);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(product);
			}
	}
}
