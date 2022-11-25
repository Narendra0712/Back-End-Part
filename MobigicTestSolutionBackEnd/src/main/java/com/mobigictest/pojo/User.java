package com.mobigictest.pojo;

import javax.persistence.*;

@Entity
@Table(name = "User")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usernid")
	private int userid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	
	@Override
	public String toString() {
		return userid + " : "+ username + " : " + password;
	
	}
	
}
