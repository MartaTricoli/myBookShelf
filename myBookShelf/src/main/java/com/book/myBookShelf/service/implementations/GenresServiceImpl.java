package com.book.myBookShelf.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myBookShelf.dto.GenresDTO;
import com.book.myBookShelf.entity.Books;
import com.book.myBookShelf.entity.Genres;
import com.book.myBookShelf.exception.MyException;
import com.book.myBookShelf.repository.BooksRepository;
import com.book.myBookShelf.repository.GenresRepository;
import com.book.myBookShelf.service.interfaces.IErrorMessageService;
import com.book.myBookShelf.service.interfaces.IGenresService;

@Service
public class GenresServiceImpl implements IGenresService {
	
	@Autowired
	private GenresRepository genR;
	
	@Autowired
	private IErrorMessageService msgS;
	
	@Autowired
	private BooksRepository bookR;

	@Override
	public void create(GenresDTO gen) throws MyException {
		Optional<Genres> g = genR.findByDescription(gen.getDescription());
		
		if (!g.isEmpty()) {
			throw new MyException(msgS.getMessagio("genre-exist"));
		}
		
		Genres genres = new Genres();
		genres.setId(gen.getId());
		genres.setDescription(gen.getDescription());
		
		genR.save(genres);
	}

	@Override
	public List<GenresDTO> getAll() {
		List<Genres> genres = genR.findAll();
		
		return genres.stream()
				.map(g -> new GenresDTO(
						g.getId(),
						g.getDescription())
						).collect(Collectors.toList());
	}

	@Override
	public void remove(GenresDTO gen) throws MyException {
		Optional<Genres> g = genR.findByDescription(gen.getDescription());
		
		if (g.isEmpty()) {
			throw new MyException(msgS.getMessagio("genre-no-exist"));
		}
		
		List<Books> books = bookR.findAll();
		
		for (Books b:books) {
			if (b.getGenre().getId() == g.get().getId()) {
				throw new MyException(msgS.getMessagio("genre-used"));
			}
		}
		
		genR.delete(g.get());
	}

	@Override
	public GenresDTO findOne(String description) throws MyException {
		Optional<Genres> g = genR.findByDescription(description);
		
		if (g.isEmpty()) {
			throw new MyException(msgS.getMessagio("genre-no-exist"));
		}
		
		return new GenresDTO(
				g.get().getId(),
				g.get().getDescription());
				
	}

}
