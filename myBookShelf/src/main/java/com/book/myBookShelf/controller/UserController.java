package com.book.myBookShelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.myBookShelf.dto.LoginDTO;
import com.book.myBookShelf.dto.UserDTO;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.response.ResponseBase;
import com.book.myBookShelf.service.interfaces.IUserService;

@RestController
@CrossOrigin
@RequestMapping("myBookShelf/user")
public class UserController {

	@Autowired
	private IUserService userS;
	
	@PostMapping("/save")
	public ResponseBase saveUser(@RequestBody (required = true) UserDTO user) {
		ResponseBase resp = new ResponseBase();
		resp.setRc(true);
		
		try {
			userS.addUser(user);
		} catch (MyException e) {
			resp.setRc(false);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody (required = true) LoginDTO login) {
		ResponseBase loginResponse = userS.loginUser(login);
		return ResponseEntity.ok(loginResponse);
	}
}
