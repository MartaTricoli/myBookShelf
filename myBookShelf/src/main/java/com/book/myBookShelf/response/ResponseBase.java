package com.book.myBookShelf.response;

public class ResponseBase {

	private Boolean rc;
	private String message;
	
	public Boolean getRc() {
		return rc;
	}
	public void setRc(Boolean rc) {
		this.rc = rc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseBase(Boolean rc, String message) {
		super();
		this.rc = rc;
		this.message = message;
	}
	public ResponseBase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
