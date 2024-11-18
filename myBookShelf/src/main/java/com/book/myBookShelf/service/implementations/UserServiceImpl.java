package com.book.myBookShelf.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.book.myBookShelf.dto.LoginDTO;
import com.book.myBookShelf.dto.UserDTO;
import com.book.myBookShelf.entity.User;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.repository.UserRepository;
import com.book.myBookShelf.response.ResponseBase;
import com.book.myBookShelf.service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository userR;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDTO user) throws MyException {
		Optional<User> u = userR.findByEmail(user.getEmail());
		
		if (!u.isEmpty()) {
			throw new MyException("this email is already registered.");
		}
		
		User newUser = new User();
		newUser.setUserId(user.getUserId());
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userR.save(newUser);
		return newUser.getUserName();
	}

	@Override
	public ResponseBase loginUser(LoginDTO login) {
		Optional<User> user1 = userR.findByEmail(login.getEmail());
		
		if (user1.isEmpty()) {
			return new ResponseBase(false, "email not valid");
		}
		
		String password = login.getPassword();
		String encodedPassword = user1.get().getPassword();
		
		if (passwordEncoder.matches(password, encodedPassword)) {
			Optional<User> user = userR.findByEmailAndPassword(login.getEmail(), encodedPassword);
			if (user.isPresent()) {
				return new ResponseBase(true, "Successful login");
			} else {
				return new ResponseBase(false, "Failed login");
			}
		} else {
			return new ResponseBase(false, "Incorrect password");
		}
	}


}