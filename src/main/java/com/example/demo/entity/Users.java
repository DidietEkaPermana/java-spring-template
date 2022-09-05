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
@Table(name = "users")
public class Users {

    @Id
	@Column(name = "id", updatable = false, nullable = false)
    private Long id;


	@Column(name = "username", nullable = false)
    private String username;


	@Column(name = "password",nullable = false)
    private String password;


	@Column(name = "role")
    private String role;

}
