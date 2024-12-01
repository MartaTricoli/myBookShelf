package com.book.myBookShelf.service.interfaces;

import java.util.List;

import com.book.myBookShelf.dto.CountriesDTO;
import com.book.myBookShelf.exception.MyException;

public interface ICountriesService {
	void create(CountriesDTO country) throws MyException;
	List<CountriesDTO> getAll();
	void remove(CountriesDTO country) throws MyException;
	CountriesDTO findOne(String description) throws MyException;
}
