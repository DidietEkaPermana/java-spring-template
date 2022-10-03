package com.example.demo.repository.jpa;

import com.example.demo.entity.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface BooksRepository extends JpaRepository<Books, String> {
    
}
