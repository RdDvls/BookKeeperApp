package com.BookKeeperApp;

import javax.persistence.*;

/**
 * Created by RdDvls on 5/23/17.
 */
@Entity
@Table(name = "books")
public class BookItem {

	@Id
	@GeneratedValue
	int id;

	@ManyToOne
	User user;

	@OneToOne
	Author author;

	@Column(nullable = false)
	String bookTitle;

	public BookItem() {
	}

	public BookItem(User user, Author author, String bookTitle) {

		this.user = user;
		this.author = author;
		this.bookTitle = bookTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
}
