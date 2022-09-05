package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Books;
import com.example.demo.exceptions.StorageException;
import com.example.demo.repository.jpa.BooksRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BooksService {
    private Logger logger = LoggerFactory.getLogger(BooksService.class);

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getBooksListAll() {

        logger.info("start get book list");

        List<Books> data = booksRepository.findAll();

        logger.info("done read repository");

        return data;
    }

    public Optional<Books> getBookById(long id) {

        Optional<Books> data = booksRepository.findById(id);

        return data;
    }

    public Books createBooks(Books newBook) {
        logger.info("start create book {}", newBook.toString());
        return booksRepository.save(newBook);
    }

    @Transactional
    public void storeBulk(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            try (InputStream inputStream = file.getInputStream()) {
                try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        CSVParser csvParser = new CSVParser(fileReader,
                                CSVFormat.DEFAULT.withFirstRecordAsHeader());) {
                    Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                    for (CSVRecord csvRecord : csvRecords) {

                        Books newBooks = new Books(Long.parseLong(csvRecord.get(0)),
                                csvRecord.get(1),
                                csvRecord.get(2));

                        booksRepository.save(newBooks);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("error processing data:  " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }
}
