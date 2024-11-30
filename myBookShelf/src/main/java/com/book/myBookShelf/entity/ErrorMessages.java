package com.book.myBookShelf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "error_messages")
public class ErrorMessages {
	@Id
	private String codice;
	
	@Column(name = "message")
	private String message;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessages(String codice, String message) {
		super();
		this.codice = codice;
		this.message = message;
	}

	public ErrorMessages() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ErrorMessages [codice=" + codice + ", message=" + message + "]";
	}
	
}
