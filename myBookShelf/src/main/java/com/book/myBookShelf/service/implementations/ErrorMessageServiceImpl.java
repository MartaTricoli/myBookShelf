package com.book.myBookShelf.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myBookShelf.entity.ErrorMessages;
import com.book.myBookShelf.repository.ErrorMessagesRepository;
import com.book.myBookShelf.service.interfaces.IErrorMessageService;

@Service
public class ErrorMessageServiceImpl implements IErrorMessageService {
	
	@Autowired
	ErrorMessagesRepository msgR;

	@Override
	public String getMessagio(String code) {
		Optional<ErrorMessages> msg = msgR.findById(code);
		String result = null;
		
		if (msg.isEmpty()) {
			result = code;
		} else {
			result = msg.get().getMessage();
		}
		return result;
	}

}
