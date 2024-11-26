package com.book.myBookShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Genres;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer>{

}
