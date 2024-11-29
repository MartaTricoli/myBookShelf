package com.book.myBookShelf.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myBookShelf.dto.SexDTO;
import com.book.myBookShelf.entity.Authors;
import com.book.myBookShelf.entity.Sex;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.repository.AuthorsRepository;
import com.book.myBookShelf.repository.SexRepository;
import com.book.myBookShelf.service.interfaces.IErrorMessageService;
import com.book.myBookShelf.service.interfaces.ISexService;

@Service
public class SexServiceImpl implements ISexService {
	
	@Autowired
	private SexRepository sexR;
	
	@Autowired
	private IErrorMessageService msgS;
	
	@Autowired
	private AuthorsRepository authR;
	
	@Override
	public void create(SexDTO sex) throws MyException {
		Optional<Sex> s = sexR.findByDescription(sex.getDescription());
		
		if (!s.isEmpty()) {
			throw new MyException(msgS.getMessagio("sex-exist"));
		}
		
		Sex sx = new Sex();
		sx.setId(sex.getId());
		sx.setDescription(sex.getDescription());
		
		sexR.save(sx);
	}

	@Override
	public List<SexDTO> getAll() {
		List<Sex> sex = sexR.findAll();
		
		return sex.stream()
				.map(s -> new SexDTO(
						s.getId(),
						s.getDescription())
						).collect(Collectors.toList());
	}

	@Override
	public void remove(SexDTO sex) throws MyException {
		Optional<Sex> s = sexR.findByDescription(sex.getDescription());
		
		if (s.isEmpty()) {
			throw new MyException(msgS.getMessagio("sex-no-exists"));
		}
		
		List<Authors> auth = authR.findAll();
		
		for (Authors a: auth) {
			if (a.getSex().getId() == s.get().getId()) {
				throw new MyException(msgS.getMessagio("sex-used"));
			}
		}
		
		sexR.delete(s.get());
		
	}

	//questo metodo deve laciare una MyException se il Sex è null/non esiste.
	@Override
	public SexDTO findOne(String description) {
		Optional<Sex> sex = sexR.findByDescription(description);
		
		if (sex.isEmpty()) {
			return new SexDTO(
					null, null);
		}
		
		return new SexDTO(
				sex.get().getId(),
				sex.get().getDescription());
	}

}
