package com.book.myBookShelf.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id", length = 45)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "user_name", length = 255)
	private String userName;
	
	@Column(name = "email", length = 255)
	private String email;
	
	@Column(name = "password", length = 255)
	private String password;
	
	@ManyToMany
	(mappedBy = "users",
	fetch = FetchType.EAGER)
	private List<Authors> authors;
	
	@ManyToMany
	(mappedBy = "users",
	fetch = FetchType.EAGER)
	private List<Books> books;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public User(int userId, String userName, String email, String password, List<Authors> authors, List<Books> books) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.authors = authors;
		this.books = books;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", authors=" + authors + ", books=" + books + "]";
	}
	
}
