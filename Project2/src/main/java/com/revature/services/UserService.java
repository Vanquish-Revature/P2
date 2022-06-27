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
	public static List<User> getUserByUserName(String user_name) throws Exception { 
		List<User> users = aDAO.getUserByUsername(user_name);
		if(users.get(0).getUser_ID() != 0) 
		{
			return users;
		}
		else 
		{
			throw new Exception();
		}
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
	public static int login(String username, String password) throws SQLException{
//		aDAO.login(username, password);
		List<User> Checkusername = aDAO.getUserByUsername(username);
		try 
		{
			User check = Checkusername.get(0);
			String usersname = check.getUsername();
			String passwords = check.getPassword();
			if(usersname.equals(username) && passwords.equals(password)) 
			{
				System.out.println("Logged in sucess!");
				return 1;
			}
			else if (usersname.equals(username)  && (!passwords.equals(password))) 
			{
				System.out.println("Wrong password");
				return 0;
			}
			else 
			{
				System.out.println("User does not exist");
				return 0;
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Login unsuccessful");
			e.printStackTrace();
			return 0;
		}
//		return aDAO.login(username, password);
//		return null;
	}
//	public static void updateUser(User user) throws SQLException{
//		aDAO.updateUser(user);
//	}

}
