package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksOutput {
    private String id;
    private String title;
    private String author;
    private Date LastUpdateDate;
    private String LastUpdateBy;
}
