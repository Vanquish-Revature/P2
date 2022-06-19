package com.revature.repo;

import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
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
	
<<<<<<< HEAD
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
=======
	public void updateUser(User user, String password, String username) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		boolean occured = false;
		try {
			if(password.equals(null) || password.equals("") || password == "") {
				
			} else {
				user.setPassword(password);
				occured = true;
			}
			if(username.equals(null) || username.equals("") || username == "") {
				
			} else {
				user.setUsername(password);
				occured = true;
			}
			if(occured == true) {
				ses.merge(user);
				tran.commit();
			}
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
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
