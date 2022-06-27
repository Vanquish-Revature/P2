package com.revature.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.models.User;
import com.revature.repo.UserDAO;
import com.revature.services.UserService;

@Controller
@ResponseBody
@RequestMapping(value="/user")
@CrossOrigin
public class UserController {
	// Login, register, update password, update username, get all, get by id
  public static UserDAO ud;
  public static UserService us;
  User u;
	@Autowired
	public UserController(UserDAO dao) {
		this.ud = dao;
	}
	@Autowired
	public void Userservice(UserService us) {
		this.us = us;
	}	

	@RequestMapping(method=RequestMethod.GET) 
//	@GetMapping("/getAllusers")
	public List<User> getAllUsers(){
		return ud.getAllUsers(); 
	}

	@GetMapping("/userID/{usr_ID}")
	public ResponseEntity<User> getUserByUserId(@PathVariable("usr_ID") int usr_ID)
	{
		User u = us.getUserById(usr_ID);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
			
		} else {
			return ResponseEntity.ok(u);
		}
	}
	
//	@RequestMapping(value = "/Username",method=RequestMethod.GET) 
	@GetMapping("/Username")
	public ResponseEntity<List<User>> getUserByName(@RequestParam(value = "username", required = false) String user_name) throws Exception
	{
		List<User>u = ud.getUserByUsername(user_name);
		if(user_name == null) 
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
		}
		else 
		{
			if(ud.getUserByUsername(user_name) != null) 
			{
				
				return ResponseEntity.ok(u);
				
			}
			else 
			{
				u = null;
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(u);
			}
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) throws SQLException{
//		if(user.getUsername() == null) 
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("0");
//		}
//		else 
//		{
//			if(ud.login(user.getUsername(), user.getPassword())!=null)
//			{
//				user = ud.login(user.getUsername(), user.getPassword());

				u = user;

//				return ResponseEntity.ok("1");
//			}
//			else 
//			{
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("0");
//			}
//		}
		if(user.getUsername() == null) 
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("0");
		}
		if(us.login(user.getUsername(), user.getPassword())!=0) {
//			user = us.login(user.getUsername(), user.getPassword());
//			u = user;
			return ResponseEntity.ok("1");
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("0");
		}
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		if(user.getUsername() == null) 
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("0");
		}
		else 
		{
			us.register(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("1");
		}
//		try {
//			ud.register(user);
//			return ResponseEntity.ok(user);
//		} catch(Exception e) { 
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
//		}
	}
	@PutMapping("/updateUser/{user_id}")
	public ResponseEntity<User> updateUser(@PathVariable("user_id") int usr_Id){ 
			User u = us.getUserById(usr_Id);
			try {
				ud.updateUser(u);
				return ResponseEntity.ok(u);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
			}
	}

}


