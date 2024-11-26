package com.book.myBookShelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myBookShelf.entity.Sex;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer>{
	Optional<Sex> findByDescription(String description);
}
