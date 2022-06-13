package com.revature.repo;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class UserDAO {
	
	public void register(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
	
	public User login(String username, String password) {
		Session ses = HibernateUtil.getSession();
		try{
			User login = ses.get(User.class, username);
			HibernateUtil.closeSession();
			//Validate if the login was even successful though i'm unsure if it wouldn't just throw an error if login ended up null.
			if(login==null) {
				System.out.println("Login Failure: User not found");
				return null;
			}
			//check to see if the password is correct
			if(login.getPassword()==password) {
				login.setPassword(""); //This is unnecessary for the project, but this makes it so that once the password is checked it no longer persists in the object
				return login;
			} else {
				HibernateUtil.closeSession();
				System.out.println("Login Failure");
				return null;
			}
		} catch(Exception e) {
			HibernateUtil.closeSession();
			e.printStackTrace();
			return null;
		}
	}
	
	public void updatePassword(User user, String password) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		try {
			user.setPassword(password);
			ses.merge(user);
			tran.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}
	
	public void updateUsername(User user, String username) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		try {
			user.setUsername(username);
			ses.merge(user);
			tran.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
	}
	
	//this is more or less for debugging and not for user use.
	
	public List<User> getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return userList;
	}
	
	public User getUserById(int user_Id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, user_Id);
		HibernateUtil.closeSession();
		return user;
	}

}
