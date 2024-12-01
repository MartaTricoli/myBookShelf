package com.book.myBookShelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Countries;
import com.book.myBookShelf.entity.Genres;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer>{
	Optional<Countries> findByDescription(String description);
}
