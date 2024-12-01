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

import com.book.myBookShelf.dto.CountriesDTO;
import com.book.myBookShelf.dto.SexDTO;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.response.ResponseBase;
import com.book.myBookShelf.service.interfaces.ICountriesService;

@RestController
@CrossOrigin
@RequestMapping("myBookShelf/country")
public class CountriesController {
	@Autowired
	private ICountriesService countryS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) CountriesDTO country) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			countryS.create(country);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list() {
		List<CountriesDTO> country = countryS.getAll();
		List<HashMap<String, Object>> resp = new ArrayList<HashMap<String, Object>>();
		
		for (CountriesDTO c:country) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", c.getId());
			map.put("country", c.getDescription());
			resp.add(map);
		}
		return resp;
	}
	
	@GetMapping("/listOne")
	public CountriesDTO listOne(@RequestParam String d){
		CountriesDTO countryDTO = new CountriesDTO();
		try {
			countryDTO = countryS.findOne(d);
		} catch (MyException e) {
			e.getMessage();
		}
		
		return countryDTO;
	}
	
	@DeleteMapping("/remove")
	public ResponseBase remove(@RequestBody (required = true) CountriesDTO country) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		
		try {
			countryS.remove(country);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
}
