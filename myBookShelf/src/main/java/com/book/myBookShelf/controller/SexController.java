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
import org.springframework.web.bind.annotation.RestController;

import com.book.myBookShelf.dto.SexDTO;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.response.ResponseBase;
import com.book.myBookShelf.service.interfaces.ISexService;

@RestController
@CrossOrigin
@RequestMapping("myBookShelf/sex")
public class SexController {

	@Autowired
	private ISexService sexS;
	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) SexDTO sex) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			sexS.create(sex);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list() {
		List<SexDTO> sex = sexS.getAll();
		List<HashMap<String, Object>> resp = new ArrayList<HashMap<String, Object>>();
		
		for (SexDTO s:sex) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", s.getId());
			map.put("sex", s.getDescription());
			resp.add(map);
		}
		return resp;
	}
	
	@DeleteMapping("/remove")
	public ResponseBase remove(@RequestBody (required = true) SexDTO sex) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			sexS.remove(sex);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
}
