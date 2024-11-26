package com.book.myBookShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

}
