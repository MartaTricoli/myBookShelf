package com.book.myBookShelf.dto;

public class BooksReadDTO {
	Integer id;
	Integer id_book;
	Integer id_user;
	Integer n_readings;
	String end_reading;
	String start_reading;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_book() {
		return id_book;
	}
	public void setId_book(Integer id_book) {
		this.id_book = id_book;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getN_readings() {
		return n_readings;
	}
	public void setN_readings(Integer n_readings) {
		this.n_readings = n_readings;
	}
	public String getEnd_reading() {
		return end_reading;
	}
	public void setEnd_reading(String end_reading) {
		this.end_reading = end_reading;
	}
	public String getStart_reading() {
		return start_reading;
	}
	public void setStart_reading(String start_reading) {
		this.start_reading = start_reading;
	}
	
	public BooksReadDTO(Integer id, Integer id_book, Integer id_user, Integer n_readings, String end_reading,
			String start_reading) {
		super();
		this.id = id;
		this.id_book = id_book;
		this.id_user = id_user;
		this.n_readings = n_readings;
		this.end_reading = end_reading;
		this.start_reading = start_reading;
	}
	public BooksReadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "BooksReadDTO [id=" + id + ", id_book=" + id_book + ", id_user=" + id_user + ", n_readings=" + n_readings
				+ ", end_reading=" + end_reading + ", start_reading=" + start_reading + "]";
	}
	
}
