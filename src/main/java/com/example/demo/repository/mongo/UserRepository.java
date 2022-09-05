package com.example.demo.repository.mongo;

import com.example.demo.entity.Users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface UserRepository extends MongoRepository<Users, Long> {
    List<Users> findByUsername(String username);
    // List<Person> findByLastName(@Param("name") String name);
}