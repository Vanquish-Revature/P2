package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.repo.UserDAO;

public class UserService {
	
	static UserDAO aDAO = new UserDAO();
	public static User getUserById(int id) { 
		User users = aDAO.getUserById(id);
		return users;
	}
	public static List<User> getAllUsers(){
		List<User> users = aDAO.getAllUsers();
		return users;
	}
	public static void register(User user) throws SQLException{
		aDAO.register(user);
	}
	public static void login(String username, String password) throws SQLException{
		aDAO.login(username, password);
	}
<<<<<<< HEAD
	public static void updatePassword(User user, String password) throws SQLException{
		aDAO.updatePassword(user, password);
	}
	public static void updateUsername(User user, String password) throws SQLException{
		aDAO.updateUsername(user, password);
=======
	public static void updateUser(User user, String password, String username) throws SQLException{
		aDAO.updateUser(user, password, username);
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
	}

}
