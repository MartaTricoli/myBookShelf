package com.book.myBookShelf.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String name;
	String lastName;
	
	@OneToMany(mappedBy = "authors",
			fetch = FetchType.EAGER)
	private List<Books> books;
	
	@ManyToMany
	(fetch = FetchType.EAGER)
	@JoinTable(
			name = "authors_read",
			joinColumns = @JoinColumn(name = "id_author"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(
			name = "id_country")
	private Countries country;
	
	@ManyToOne
	@JoinColumn(
			name = "id_sex")
	private Sex sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Authors(Integer id, String name, String lastName, List<Books> books, List<User> users, Countries country,
			Sex sex) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.books = books;
		this.users = users;
		this.country = country;
		this.sex = sex;
	}

	public Authors() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", lastName=" + lastName + ", books=" + books + ", users="
				+ users + ", country=" + country + ", sex=" + sex + "]";
	}
	
}
