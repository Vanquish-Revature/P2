package com.revature.repo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;
@Repository
public class UserDAO {
	User u = new User();
	public int register(User user) {
		try(Session session = HibernateUtil.getSession())
		{
			session.save(user);
			HibernateUtil.closeSession();
			return 1;
		}
		catch(Exception e) 
		{
			System.out.println("There was an error inserting the user");
			e.printStackTrace();
			return 0;
		}
	}
	
//	public User login(String username, String password) {
//		Session ses = HibernateUtil.getSession();
//		Query q = ses.createQuery("FROM user WHERE username =?1");
//		q.setParameter(1, username);
//		try{
//			List<User> userList = q.getResultList();
//			User login = ses.get(User.class, username);
//			HibernateUtil.closeSession();
//			u = userList.get(0);
			//Validate if the login was even successful though i'm unsure if it wouldn't just throw an error if login ended up null.
//			if(login==null) {
//				System.out.println("Login Failure: User not found");
//				return null;
//			}
			//check to see if the password is correct
//			if(login.getPassword()==password) {
//				login.setPassword(""); //This is unnecessary for the project, but this makes it so that once the password is checked it no longer persists in the object
//				return login;
//			} else {
//				HibernateUtil.closeSession();
//				System.out.println("Login Failure");
//				return null;
//			}
//		} catch(Exception e) {
//			HibernateUtil.closeSession();
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public void updateUser(User user) {
		try(Session ses = HibernateUtil.getSession())
		{
			Transaction tran = ses.beginTransaction();
			Query q = ses.createQuery("UPDATE User SET username = '" + user.getUsername() + "', password = '" + user.getPassword() +"', firstname = '" + user.getFirstname()
			+ "', lastname = '" + user.getLastName() + "' WHERE  user_id = " + user.getUser_ID());
			q.executeUpdate();
			tran.commit();
			HibernateUtil.closeSession();
		}
		catch(Exception e)
		{
			System.out.println("There was an error updating the user");
			e.printStackTrace();
		}
//		boolean occured = false;
//		try {
//			if(user.getPassword().equals(null) || user.getPassword().equals("") || user.getPassword() == "") {
//				
//			} else {
//				user.setPassword(user.getPassword());
//				occured = true;
//			}
//			if(username.equals(null) || username.equals("") || username == "") {
//				
//			} else {
//				user.setUsername(user.getUsername());
//				occured = true;
//			}
//			if(firstname.equals(null) || firstname.equals("") || firstname == "") {
//				
//			} else {
//				user.setFirstname(user.getFirstname());
//				occured = true;
//			}
//			if(lastname.equals(null) || lastname.equals("") || lastname == "") {
//				
//			} else {
//				user.setLastName(user.getLastName());
//				occured = true;
//			}
//			if(occured == true) {
//				ses.merge(user);
//				tran.commit();
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		HibernateUtil.closeSession();
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
	public List<User> getUserByUsername(String username) {
		try(Session ses = HibernateUtil.getSession())
		{
			Query q = ses.createQuery("FROM User WHERE username =?1");
			q.setParameter(1, username);
			List<User> user = q.getResultList();
//			ses.save(user);
			HibernateUtil.closeSession();
			return user;
		}
		catch(HibernateException e)
		{
			System.out.println("There was an error getting user by username");
			return null;
		}
//		Session ses = HibernateUtil.getSession();
//		Query q = ses.createQuery("FROM User WHERE username = ?1");
//		q.setParameter(1, username);
//		try 
//		{
//			List<User> userList = q.getResultList();
//			HibernateUtil.closeSession();
//			u = userList.get(0);
//			
//			System.out.println("user exists");
//			return u;
//		}
//		catch(Exception e) 
//		{
//			e.printStackTrace();
//			return null;
//			
//		}
//		User user = ses.get(User.class, username);
//		HibernateUtil.closeSession();
//		return user;
	}

}
