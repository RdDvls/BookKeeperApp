package com.BookKeeperApp;

import javax.persistence.*;

/**
 * Created by RdDvls on 5/23/17.
 */
@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false)
	String firstName;

	@Column(nullable = false)
	String lastName;

	@Column(nullable = false, unique = true)
	String userName;

	@Column(nullable = false)
	String password;

	public User() {
	}

	public User(String firstName, String lastName, String userName, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
