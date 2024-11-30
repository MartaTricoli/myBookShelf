package com.book.myBookShelf.service.interfaces;

import java.util.List;

import com.book.myBookShelf.dto.GenresDTO;
import com.book.myBookShelf.exception.MyException;

public interface IGenresService {

	void create(GenresDTO gen) throws MyException;
	List<GenresDTO> getAll();
	void remove(GenresDTO gen) throws MyException;
	GenresDTO findOne(String description) throws MyException;
}
