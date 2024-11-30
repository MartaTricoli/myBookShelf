package com.book.myBookShelf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "books_read")
public class BooksRead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String start_reading;
	String end_reading;
	Integer n_readings;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStart_reading() {
		return start_reading;
	}
	public void setStart_reading(String start_reading) {
		this.start_reading = start_reading;
	}
	public String getEnd_reading() {
		return end_reading;
	}
	public void setEnd_reading(String end_reading) {
		this.end_reading = end_reading;
	}
	public Integer getN_readings() {
		return n_readings;
	}
	public void setN_readings(Integer n_readings) {
		this.n_readings = n_readings;
	}
	public BooksRead(Integer id, String start_reading, String end_reading, Integer n_readings) {
		super();
		this.id = id;
		this.start_reading = start_reading;
		this.end_reading = end_reading;
		this.n_readings = n_readings;
	}
	public BooksRead() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BooksRead [id=" + id + ", start_reading=" + start_reading + ", end_reading=" + end_reading
				+ ", n_readings=" + n_readings + "]";
	}
	
	
}
