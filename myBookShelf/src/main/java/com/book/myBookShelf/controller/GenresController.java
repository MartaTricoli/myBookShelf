package com.book.myBookShelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.myBookShelf.dto.GenresDTO;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.response.ResponseBase;
import com.book.myBookShelf.service.interfaces.IGenresService;

@RestController
@CrossOrigin
@RequestMapping("myBookShelf/genre")
public class GenresController {

	@Autowired
	private IGenresService genS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) GenresDTO genre) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			genS.create(genre);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
}
