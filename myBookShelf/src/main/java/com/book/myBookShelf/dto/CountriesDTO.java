package com.book.myBookShelf.dto;

public class CountriesDTO {
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
	
	public CountriesDTO(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public CountriesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CountriesDTO [id=" + id + ", description=" + description + "]";
	}
	
}
