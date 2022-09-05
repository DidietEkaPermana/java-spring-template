package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

    @Column(name = "title", nullable = false)
	private String title;

    @Column(name = "author", nullable = false)
	private String author;
}
