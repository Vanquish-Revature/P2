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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.models.Product;
import com.revature.repo.ProductDAO;


@Controller
@ResponseBody
@RequestMapping(value="/rainforest")
@CrossOrigin
public class ProductController {
	
	private ProductDAO pDAO;
	
	@Autowired //This annotation we are now using constructor injection to inject ProductDAO as a dependency 
	//This is our constructor that will allow us to use constructor injection and our DAO methods
	public ProductController(ProductDAO dao) {
		this.pDAO = dao;
	}
	
	//Lets declare some methods to handle HTTP requests (This is the big replacement for Javalin)
	
		//Lets get all product
		@RequestMapping(method=RequestMethod.GET) //This will ensure that any Get request to /rainforest goes here
		public List<Product> listProduct(){
			return Arrays.asList(pDAO.getAll()); //.getAll() returns an array, so we need to convert it to a list and we can do that using Arrays.asList()
		}
		
		
		//Lets do get by id
		@GetMapping("/{id}") //GetMapping will specify that GET requests that are sent to /rainforest are sent here as well
		//But we also added in a path parameter. So any GET request with /rainforest/(some number) will actually be sent to this method
		//@PathVariable annotation will allow you to grab that path variable sent in the URL, for us it is id, but it can be whatever you set it to
		//Spring has an object called ResponseEnitiy that lets us set things like status code, and the response body
		public ResponseEntity<Avenger> getById(@PathVariable("id") int id){ 
			Product a = ad.getById(id); //This will get product with the id that comes from the Path Parameter that got sent with the request
			if(a == null) {
				//We could type in the code 204 which means "no content"
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
			}
			else {//if the product is NOT null then this will actually go off
				//You can also just do return ResponseEntity.status(200).body(a);
				return ResponseEntity.ok(a);// This is shorthand for return ResponseEntity.status(HttpStatus.OK).body(a);
			}
		}
		

}
