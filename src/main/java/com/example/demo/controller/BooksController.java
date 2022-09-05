package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping
	List<Books> all() {
		return booksService.getBooksListAll();
	}

    @GetMapping("/{id}")
	Optional<Books> findById(@PathVariable Long id) {
		return booksService.getBookById(id);
	}

    @PostMapping
    Books newBooks(@RequestBody Books newBooks) {
		return booksService.createBooks(newBooks);
    }

    @PostMapping("/uploadData")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        try {
            booksService.storeBulk(file);   
        } catch (Exception e) {
            //TODO: handle exception
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return "ok";
    }
}