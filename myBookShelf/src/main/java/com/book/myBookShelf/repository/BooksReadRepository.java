package com.book.myBookShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.BooksRead;

@Repository
public interface BooksReadRepository extends JpaRepository<BooksRead, Integer>{

}
