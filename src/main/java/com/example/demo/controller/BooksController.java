package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.BooksInput;
import com.example.demo.dto.BooksOutput;
import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
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
    BooksOutput newBooks(@RequestBody BooksInput newBooks) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

        // Books addedBooks = new Books(UUID.randomUUID().toString(), newBooks.getTitle(), newBooks.getAuthor());

        // addedBooks.setCreatedDate(new Date());
        // addedBooks.setCreatedBy(userName);
        // addedBooks.setLastUpdateDate(new Date());
        // addedBooks.setLastUpdateBy(userName);

        Books addedBooks = Books.builder()
                            .id(UUID.randomUUID().toString())
                            .title(newBooks.getTitle())
                            .author(newBooks.getAuthor())
                            .CreatedBy(userName)
                            .CreatedDate(new Date())
                            .LastUpdateBy(userName)
                            .LastUpdateDate(new Date())
                            .build();

        addedBooks = booksService.createBooks(addedBooks);

        BooksOutput booksOutput = new BooksOutput(addedBooks.getId(), addedBooks.getTitle(), addedBooks.getAuthor(), addedBooks.getLastUpdateDate(), addedBooks.getLastUpdateBy());

		return booksOutput;
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