package com.book.myBookShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer>{

}
