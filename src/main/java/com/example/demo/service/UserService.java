// package com.example.demo.service;

// import com.example.demo.entity.Users;
// import com.example.demo.dto.UserCreateRequest;
// import com.example.demo.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// import javax.persistence.EntityNotFoundException;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     public Users readUserByUsername (String username) {
//         return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
//     }

//     public void createUser(UserCreateRequest userCreateRequest) {
//         Users apiUser = new Users();
//         Optional<Users> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
//         if (byUsername.isPresent()) {
//             throw new RuntimeException("User already registered. Please use different username.");
//         }
//         apiUser.setUsername(userCreateRequest.getUsername());
//         apiUser.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
//         apiUser.setRole(userCreateRequest.getRole());
//         userRepository.save(apiUser);
//     }
// }