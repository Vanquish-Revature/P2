package com.revature.repo;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Order;
import com.revature.utilities.HibernateUtil;



public class OrderDAO {
	
	
	public int submitOrder(Order orders) {
		try(Session ses = HibernateUtil.getSession()){
		ses.save(orders);
		HibernateUtil.closeSession();
		return 1;
	}
		catch(HibernateException e) {
			System.out.println("There was an error submitting your order!");
			return 0;
		}
	}
	
	public List<Order> getAllOrders() {
		Session ses = HibernateUtil.getSession();
		List<Order> orderList = ses.createQuery("FROM Order").list();
		HibernateUtil.closeSession();
		return orderList;
	}
	

	
	
	
//	add
//	
//	remove
//	
	
//	public List<Order> getOrdersByProductId(int id){
//		Session ses = HibernateUtil.getSession(); 
//		Query q = ses.createQuery("FROM orders o WHERE o.product.id = ?0");
//		q.setParameter(0, id);
//		List<Order> orderList = q.getResultList();
//		HibernateUtil.closeSession();
//		return orderList;
//	}
	
	//update order?
	
}
