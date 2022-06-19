package com.revature;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.Product;
import com.revature.repo.ProductDAO;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {
	//	SpringApplication.run(Project2Application.class, args);
		
	//	System.out.println("Hello There");
	//}

			

	ProductDAO plant = new ProductDAO();
	
	Product p1 = new Product(1, "Rattlesnake Plant", 10.00, 10);
	Product p2 = new Product(2, "Swiss Cheese Plant", 0.00, 10);
	Product p3 = new Product(3, "Friendship Plant", 0.00, 10);
	Product p4 = new Product(4, "Purple Blush Plant", 0.00, 10);
	Product p5 = new Product(5, "Golden Pothos Plant", 0.00, 10);
	
	plant.insertProduct(p1);
	plant.insertProduct(p2);
	plant.insertProduct(p3);
	plant.insertProduct(p4);
	plant.insertProduct(p5);
//	
	
	//Lets get a list of all of our plants and see what the console says
//	List<Product> allProduct = plant.getAllProduct();{
//	for(Product p : allProduct) {
//		System.out.println(p);
//	 }
	
	}
}
			
