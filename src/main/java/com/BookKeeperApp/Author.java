package com.BookKeeperApp;

import javax.persistence.*;

/**
 * Created by RdDvls on 5/23/17.
 */
@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false)
	String firstName;

	@Column(nullable = false)
	String lastName;

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
