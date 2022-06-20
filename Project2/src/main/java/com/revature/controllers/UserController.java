package com.revature.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repo.UserDAO;

@Controller
@ResponseBody
@RequestMapping(value="/user")
@CrossOrigin
public class UserController {
	// Login, register, update password, update username, get all, get by id
  public static UserDAO ud;
	
	@Autowired
	public UserController(UserDAO dao) {
		this.ud = dao;
	}	

	@RequestMapping(method=RequestMethod.GET) 
	public List<User> getAllUsers(){
		return ud.getAllUsers(); 
	}
	@GetMapping("/login")
	public ResponseEntity<User> login(@PathVariable("user")User user){
		if(user == ud.getUserById(user.getUser_ID())) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
	}
	@PostMapping("/register")
	public ResponseEntity<User> register(@PathVariable("user")User user){
		try {
			ud.register(user);
			return ResponseEntity.ok(user);
		} catch(Exception e) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}
	}
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@PathVariable("user")User user, String password, String username){ 
			try {
				ud.updateUser(user, password, username);
				return ResponseEntity.ok(user);
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
			}
	}
}
