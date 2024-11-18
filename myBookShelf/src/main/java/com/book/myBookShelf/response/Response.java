package com.book.myBookShelf.response;

import java.util.List;

public class Response<T> extends ResponseBase {

	public Response(Boolean rc, String message) {
		super(rc, message);
		// TODO Auto-generated constructor stub
	}

	private List<T> dati;

	public List<T> getDati() {
		return dati;
	}

	public void setDati(List<T> dati) {
		this.dati = dati;
	}
	
}
