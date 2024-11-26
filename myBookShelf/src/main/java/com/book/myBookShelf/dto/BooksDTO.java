package com.book.myBookShelf.dto;

public class BooksDTO {
	Integer id;
	Integer id_author;
	Integer id_genre;
	Integer id_original_language;
	Integer year_of_publication;
	String original_title;
	String title;
	String url_image;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_author() {
		return id_author;
	}
	public void setId_author(Integer id_author) {
		this.id_author = id_author;
	}
	public Integer getId_genre() {
		return id_genre;
	}
	public void setId_genre(Integer id_genre) {
		this.id_genre = id_genre;
	}
	public Integer getId_original_language() {
		return id_original_language;
	}
	public void setId_original_language(Integer id_original_language) {
		this.id_original_language = id_original_language;
	}
	public Integer getYear_of_publication() {
		return year_of_publication;
	}
	public void setYear_of_publication(Integer year_of_publication) {
		this.year_of_publication = year_of_publication;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl_image() {
		return url_image;
	}
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}
	
	public BooksDTO(Integer id, Integer id_author, Integer id_genre, Integer id_original_language,
			Integer year_of_publication, String original_title, String title, String url_image) {
		super();
		this.id = id;
		this.id_author = id_author;
		this.id_genre = id_genre;
		this.id_original_language = id_original_language;
		this.year_of_publication = year_of_publication;
		this.original_title = original_title;
		this.title = title;
		this.url_image = url_image;
	}
	
	public BooksDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "BooksDTO [id=" + id + ", id_author=" + id_author + ", id_genre=" + id_genre + ", id_original_language="
				+ id_original_language + ", year_of_publication=" + year_of_publication + ", original_title="
				+ original_title + ", title=" + title + ", url_image=" + url_image + "]";
	}
	
}
