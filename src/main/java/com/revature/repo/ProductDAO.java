package com.revature.repo;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Product;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

@Repository
public class ProductDAO {
	Product p = new Product();

//	@PersistenceContext
//    public static void insertProduct(Product product) {
//	Session ses = HibernateUtil.getSession(); //This will open our session object to establish a connection to our database
//	ses.save(product);
//	HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
//} 
	
	@PersistenceContext
	public static void insertProduct(Product product) {
		try(Session ses = HibernateUtil.getSession()){
			ses.save(product);
			HibernateUtil.closeSession();
		} catch(HibernateException e) {
		    System.out.println(e);
		    e.printStackTrace();
		}
	}
	

//We are going to use HQL for this ones
	public List<Product> getAllProduct(){
		Session ses = HibernateUtil.getSession(); //This opens the session
		List<Product> productList = ses.createQuery("FROM Product").list(); //This is HQL which will get all items from the Movie Table
		HibernateUtil.closeSession(); //This closes the session
		return productList; //This returns the list
}
	
	public Product getProductById(int product_ID) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Product product = ses.get(Product.class, product_ID); //This will select all product by ID
		HibernateUtil.closeSession(); //closes the session
		return product; //returns the movie
	}
	
	//will this be in cartDAO??? idk ---vi
	public List<Product> getProductByUserId(int user_ID){
		Session ses = HibernateUtil.getSession(); //opens the session
		Query q = ses.createQuery("FROM product p WHERE p.product.id = ?0"); 
		//The 0 is what we are targeting to change with our setParameter
		q.setParameter(0, user_ID); //This sets the ? to the id that we sent to this method
		List<Product> productList = q.getResultList(); //This will create a List that will hold the results of our query
		HibernateUtil.closeSession(); //closes the session
		return productList; //returns our list
	}
	
	public Product getProductByName(String product_name){
		
//		Session ses = HibernateUtil.getSession(); //opens the session
//		Query q = ses.createQuery("FROM Product m WHERE m.product.id = ?0"); 
		//The 0 is what we are targeting to change with our setParameter
//		q.setParameter(0, product_name); //This sets the ? to the id that we went to this method
//		List<Product> productList = q.getResultList(); //This will create a List that will hold the results of our query
//		HibernateUtil.closeSession(); //closes the session
//		return productList; //returns our list
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM Product WHERE plant_name = ?1");
		q.setParameter(1, product_name);
		try 
		{
			List<Product> userList = q.getResultList();
			HibernateUtil.closeSession();
			p = userList.get(0);
			
			System.out.println("product exits");
			return p;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return null;
			
		}
	}
	

	
	//We will use session method to update
		public void updateProductWithSessionMethod(Product product) {
			Session ses = HibernateUtil.getSession(); //opens the session
			Transaction tran = ses.beginTransaction(); //ALL and I do mean ALL update and delete methods MUST happen within a transaction
			ses.merge(product); //this will actually merge our product object with the database 
			tran.commit(); //This will commit the transaction if it did not encounter a problem
			HibernateUtil.closeSession(); //closes the session

		}
		//We will use HQL to update
		public void updateProductWithHQL(Product product) {
			Session ses = HibernateUtil.getSession(); //opens the session
			Transaction tran = ses.beginTransaction(); //ALL and I do mean ALL update and delete methods MUST happen within a transaction
			Query q = ses.createQuery("UPDATE Product SET quantity = '" + product.getProduct_name() + "' WHERE id = " + product.getProduct_ID());
			//This is what that string looks like when data is given "UPDATE Movie SET title = 'New Movie Title' Where id = 2"
			q.executeUpdate();
			tran.commit(); //This will commit the transaction if it did not encounter a problem
			HibernateUtil.closeSession(); //closes the session
		}
		
		// checkout item remove an amount from quantity.
	
}
