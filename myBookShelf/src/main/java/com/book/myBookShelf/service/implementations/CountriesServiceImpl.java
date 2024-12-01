package com.book.myBookShelf.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myBookShelf.dto.CountriesDTO;
import com.book.myBookShelf.dto.GenresDTO;
import com.book.myBookShelf.dto.SexDTO;
import com.book.myBookShelf.entity.Authors;
import com.book.myBookShelf.entity.Countries;
import com.book.myBookShelf.entity.Genres;
import com.book.myBookShelf.entity.Sex;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.repository.AuthorsRepository;
import com.book.myBookShelf.repository.CountriesRepository;
import com.book.myBookShelf.service.interfaces.ICountriesService;
import com.book.myBookShelf.service.interfaces.IErrorMessageService;

@Service
public class CountriesServiceImpl implements ICountriesService{
	@Autowired
	private CountriesRepository countryR;
	
	@Autowired
	private IErrorMessageService msgS;
	
	@Autowired
	private AuthorsRepository authR;

	@Override
	public void create(CountriesDTO country) throws MyException {
		Optional<Countries> c = countryR.findByDescription(country.getDescription());
		
		if (!c.isEmpty()) {
			throw new MyException(msgS.getMessagio("country-exist"));
		}
		
		Countries cnt = new Countries();
		cnt.setId(country.getId());
		cnt.setDescription(country.getDescription());
		
		countryR.save(cnt);
	}

	@Override
	public List<CountriesDTO> getAll() {
		List<Countries> cnt = countryR.findAll();
		
		return cnt.stream()
				.map(c -> new CountriesDTO(
						c.getId(),
						c.getDescription())
						).collect(Collectors.toList());
	}

	@Override
	public void remove(CountriesDTO country) throws MyException {
		Optional<Countries> c = countryR.findByDescription(country.getDescription());
		
		if (c.isEmpty()) {
			throw new MyException(msgS.getMessagio("country-no-exists"));
		}
		
		List<Authors> auth = authR.findAll();
		
		for (Authors a: auth) {
			if (a.getCountry().getId() == c.get().getId()) {
				throw new MyException(msgS.getMessagio("country-used"));
			}
		}
		
		countryR.delete(c.get());
		
	}

	@Override
	public CountriesDTO findOne(String description) throws MyException {
		Optional<Countries> country = countryR.findByDescription(description);
		
		if (country.isEmpty()) {
			throw new MyException(msgS.getMessagio("country-no-exist")); 
		}
		
		return new CountriesDTO(
				country.get().getId(),
				country.get().getDescription());
	}

}
