package com.book.myBookShelf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list() {
		List<GenresDTO> gen = genS.getAll();
		List<HashMap<String, Object>> resp = new ArrayList<HashMap<String, Object>>();
		
		for (GenresDTO g:gen) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", g.getId());
			map.put("genre", g.getDescription());
			resp.add(map);
		}
		return resp;
	}
	
	@GetMapping("/listOne")
	public GenresDTO listOne(@RequestParam String d) {
		GenresDTO gen = new GenresDTO();
		try {
			gen = genS.findOne(d);
		} catch (MyException e) {
			e.getMessage();
		}
		return gen;
	}
	
	@DeleteMapping("remove")
	public ResponseBase remove(@RequestBody (required = true) GenresDTO gen) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			genS.remove(gen);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
}
