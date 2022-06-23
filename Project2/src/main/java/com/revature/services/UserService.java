package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repo.ProductDAO;
import com.revature.repo.UserDAO;
@Service
public class UserService {
	
	private static UserDAO aDAO;
	
	
	@Autowired
	public UserService (UserDAO uDAO) {
		this.aDAO =uDAO;
	}
	public static User getUserById(int id) { 
		User users = aDAO.getUserById(id);
		return users;
	}
	public static User getUserByUserName(String user_name) { 
		User users = aDAO.getUserByUsername(user_name);
		return users;
	}
	public static List<User> getAllUsers(){
		List<User> users = aDAO.getAllUsers();
		return users;
	}
	public static void register(User user){
		aDAO.register(user);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastName());
//		System.out.println("User success register");
	}
	public static User login(String username, String password) throws SQLException{
		User user;
		try 
		{
			user = aDAO.getUserByUsername(username);
			if(user!= null && password.equals(user.getPassword())) 
			{
				System.out.println("Logged in sucess!");
				return user;
			}
			else if (user != null && !password.equals(user.getPassword())) 
			{
				System.out.println("Wrong password");
				return null;
			}
			else 
			{
				System.out.println("User does not exist");
				return null;
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Login unsuccessful");
			e.printStackTrace();
		}
//		return aDAO.login(username, password);
		return null;
	}
	public static void updateUser(User user, String username, String password , String firstname, String lastname) throws SQLException{
		aDAO.updateUser(user,username,password,firstname,lastname);
	}

}
