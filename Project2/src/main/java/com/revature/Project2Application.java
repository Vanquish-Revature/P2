package com.revature;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repo.ProductDAO;
import com.revature.repo.UserDAO;

import com.revature.models.Cart;
import com.revature.models.Order;
import com.revature.models.Product;
import com.revature.repo.CartDAO;
import com.revature.repo.OrderDAO;
import com.revature.repo.ProductDAO;


@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {

		SpringApplication.run(Project2Application.class, args);
		
		System.out.println("Hello There");

//		UserDAO user = new UserDAO();
//		
//		User u1 = new User(1,"test","test","Cody","Jenkins");
//		User u2 = new User(2,"admin","test","Kevin","Winter");
//		User u3 = new User(3,"guest","test","Robert","Hannah");
//		
//		user.register(u1);
//		user.register(u2);
//		user.register(u3);		
//
//	ProductDAO plant = new ProductDAO();
//		
//		 Product p1 = new Product(1, "Rattlesnake Plant", 10.00, 10);
//		 Product p2 = new Product(2, "Swiss Cheese Plant", 0.00, 10);
//		 Product p3 = new Product(3, "Friendship Plant", 0.00, 10);
//		 Product p4 = new Product(4, "Purple Blush Plant", 0.00, 10);
//		 Product p5 = new Product(5, "Golden Pothos Plant", 0.00, 10);
//		 

	SpringApplication.run(Project2Application.class, args);
	

////	
//		
//		plant.insertProduct(p1);


		
//		 Product p1 = new Product(1, "Monstera", "Monstera are species of evergreen tropical vines and shrubs that are native to Central America. They are famous for their natural leaf-holes, which has led to the rise of their nickname, Swiss Cheese Plant.", 10.00, 10);
//		 Product p2 = new Product(2, "Swiss Cheese Plant","", 0.00, 10);
//		 Product p3 = new Product(3, "Friendship Plant", "",0.00, 10);
//		 Product p4 = new Product(4, "Purple Blush Plant", "", 0.00, 10);
//		 Product p5 = new Product(5, "Golden Pothos Plant", "", 0.00, 10);
//		

//		plant.insertProduct(p1);
//		plant.insertProduct(p2);
//		plant.insertProduct(p3);
//		plant.insertProduct(p4);
//		plant.insertProduct(p5);

	

	
	//Lets get a list of all of our plants and see what the console says
//	List<Product> allProduct = plant.getAllProduct();{
//	for(Product p : allProduct) {
//		System.out.println(p);
//	 }
	
	}
			

	
	
	
	

}



