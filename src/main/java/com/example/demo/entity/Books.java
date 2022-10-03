package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "books")
public class Books extends AuditData {
    @Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

    @Column(name = "title", nullable = false)
	private String title;

    @Column(name = "author", nullable = false)
	private String author;

}
