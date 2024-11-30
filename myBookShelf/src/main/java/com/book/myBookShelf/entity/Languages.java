package com.book.myBookShelf.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "languages")
public class Languages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(length = 250)
	String description;
	
	@OneToMany(mappedBy = "id",
			fetch = FetchType.EAGER)
	private List<Books> books;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public Languages(Integer id, String description, List<Books> books) {
		super();
		this.id = id;
		this.description = description;
		this.books = books;
	}

	public Languages() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Languages [id=" + id + ", description=" + description + ", books=" + books + "]";
	}
	
}
