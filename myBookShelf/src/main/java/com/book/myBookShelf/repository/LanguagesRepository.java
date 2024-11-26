package com.book.myBookShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Languages;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Integer>{

}
