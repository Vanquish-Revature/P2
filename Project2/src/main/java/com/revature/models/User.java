package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,name = "user_id")
	private int user_ID;
	@Column(nullable = false)
	private String username;
	@Column( name = "password",nullable = false)
	private String password;
//	@Column(unique = true, nullable = false)
//	private int account;
//	
	public int getUser_ID() {
		return user_ID;
	}
	
//	public int getAccount() {
//		return account; 
//	}

//	public void setAccount(int account) {
//		this.account = account;
//	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public User(int user_ID, String username, String password) {
		super();
		this.user_ID = user_ID;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_ID=" + user_ID + ", username=" + username + ", password=" + password + "]";
	}

	
	
	
	
}
