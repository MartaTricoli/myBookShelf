package com.book.myBookShelf.dto;

public class AuthorsDTO {
	Integer id;
	String name;
	String lastName;
	Integer id_country;
	Integer id_sex;
	
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
	public Integer getId_country() {
		return id_country;
	}
	public void setId_country(Integer id_country) {
		this.id_country = id_country;
	}
	public Integer getId_sex() {
		return id_sex;
	}
	public void setId_sex(Integer id_sex) {
		this.id_sex = id_sex;
	}
	public AuthorsDTO(Integer id, String name, String lastName, Integer id_country, Integer id_sex) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.id_country = id_country;
		this.id_sex = id_sex;
	}
	public AuthorsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthorsDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", id_country=" + id_country
				+ ", id_sex=" + id_sex + "]";
	}
	
}
