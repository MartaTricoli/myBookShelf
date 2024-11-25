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
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String title;
	
	@ManyToOne
	@JoinColumn(
			name = "id_author")
	private Authors authors;
	
	Integer year_of_publication;
	String url_image;
	String original_title;
	
	@ManyToOne
	@JoinColumn(
			name = "id_original_language")
	private Languages originalLanguage;
	
	@ManyToOne
	@JoinColumn(
			name = "id_genres")
	private Genres genre;
	
	@ManyToMany
	(fetch = FetchType.EAGER)
	@JoinTable(
			name = "books_read",
			joinColumns = @JoinColumn(name = "id_book"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	public Integer getYear_of_publication() {
		return year_of_publication;
	}

	public void setYear_of_publication(Integer year_of_publication) {
		this.year_of_publication = year_of_publication;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public Languages getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(Languages originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Books(Integer id, String title, Authors authors, Integer year_of_publication, String url_image,
			String original_title, Languages originalLanguage, Genres genre, List<User> users) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.year_of_publication = year_of_publication;
		this.url_image = url_image;
		this.original_title = original_title;
		this.originalLanguage = originalLanguage;
		this.genre = genre;
		this.users = users;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", authors=" + authors + ", year_of_publication="
				+ year_of_publication + ", url_image=" + url_image + ", original_title=" + original_title
				+ ", originalLanguage=" + originalLanguage + ", genre=" + genre + ", users=" + users + "]";
	}
	
}
