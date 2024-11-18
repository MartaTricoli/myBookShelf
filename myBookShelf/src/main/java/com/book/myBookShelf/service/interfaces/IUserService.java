package com.book.myBookShelf.service.interfaces;

import com.book.myBookShelf.dto.LoginDTO;
import com.book.myBookShelf.dto.UserDTO;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.response.ResponseBase;

public interface IUserService {

	String addUser(UserDTO user) throws MyException;

	ResponseBase loginUser(LoginDTO login);
}
