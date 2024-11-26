package com.book.myBookShelf.dto;

public class LanguagesDTO {
	Integer id;
	String description;
	
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
	public LanguagesDTO(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public LanguagesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LanguagesDTO [id=" + id + ", description=" + description + "]";
	}
}
