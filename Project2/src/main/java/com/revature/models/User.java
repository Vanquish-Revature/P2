package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,name = "user_id")
	private int user_ID;
	@Column(name = "username",nullable = false)
	private String username;
	@Column( name = "password",nullable = false)
	private String password;
//	@Column(unique = true, nullable = false)
//	private int account;
	@Column(name = "firstName",nullable = false)
	private String firstname;
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public User(int user_ID, String username, String password, String firstName, String lastName) {
		super();
		this.user_ID = user_ID;
		this.username = username;
		this.password = password;
		this.firstname = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [user_ID=" + user_ID + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastName=" + lastName + "]";
	}

	
	
	
	
}
