package com.revature.models;

<<<<<<< HEAD
public class User {
	private int user_ID;
	private String username;
	private String password;
	private double account;
=======
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
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
	public int getUser_ID() {
		return user_ID;
	}
	
<<<<<<< HEAD
	public double getAccount() {
		return account; 
	}

	public void setAccount(double account) {
		this.account = account;
=======
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
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
<<<<<<< HEAD
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
	public User(int user_ID, String username, String password, double account) {
=======

	public User(int user_ID, String username, String password) {
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
		super();
		this.user_ID = user_ID;
		this.username = username;
		this.password = password;
<<<<<<< HEAD
		this.account = account;
=======
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "User [user_ID=" + user_ID + ", username=" + username + ", password=" + password + ", account=" + account
				+ "]";
=======
		return "User [user_ID=" + user_ID + ", username=" + username + ", password=" + password + "]";
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
	}

	
	
	
<<<<<<< HEAD
=======
	
>>>>>>> 4affc403d369af37428f90018c824dabfa5078ea
}
