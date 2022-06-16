package com.revature.repo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.Order;
import com.revature.utilities.HibernateUtil;

public class OrderDAO {
	
	public void submitOrder(Order orders) {
		Session ses = HibernateUtil.getSession();
		ses.save(orders);
		HibernateUtil.closeSession();
	}
	
	public List<Order> getAllOrders() {
		Session ses = HibernateUtil.getSession();
		List<Order> orderList = ses.createQuery("FROM orders").list();
		HibernateUtil.closeSession();
		return orderList;
	}
	
	public Order getOrderById(int id) {
		Session ses = HibernateUtil.getSession(); 
		Order order = ses.get(Order.class, id); 
		HibernateUtil.closeSession();
		return order; 
	}
	
	public List<Order> getOrdersByProductId(int id){
		Session ses = HibernateUtil.getSession(); 
		Query q = ses.createQuery("FROM orders o WHERE o.product.id = ?0");
		q.setParameter(0, id);
		List<Order> orderList = q.getResultList();
		HibernateUtil.closeSession();
		return orderList;
	}
	
	//update order?
	
}
