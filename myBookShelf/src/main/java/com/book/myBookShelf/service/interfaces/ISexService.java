package com.book.myBookShelf.service.interfaces;

import java.util.List;

import com.book.myBookShelf.dto.SexDTO;
import com.book.myBookShelf.exception.MyException;

public interface ISexService {
	void create(SexDTO sex) throws MyException;
	List<SexDTO> getAll();
	void remove(SexDTO sex) throws MyException;
	SexDTO findOne(Integer id);
}
