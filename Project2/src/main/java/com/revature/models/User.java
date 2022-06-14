package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_ID")
//
//@Table (name = "user")

public class User {
	@Id //This will label "id" as a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This will make our Primary key serialized
	@Column(name = "user_id", unique = true)
	private int user_ID;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	
	//private double bank;
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
