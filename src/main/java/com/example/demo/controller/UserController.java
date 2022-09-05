package com.example.demo.controller;

import com.example.demo.dto.UserCreateRequest;
import com.example.demo.entity.Users;
import com.example.demo.service.JwtTokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping(value = "/authenticate")
    public String authenticate(@RequestBody final UserCreateRequest userCreateRequest) {
        // try {
        //     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        //         userCreateRequest.getUsername(), userCreateRequest.getPassword()));
        // } catch (final BadCredentialsException ex) {
        //     throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        // }

        // final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
        // final AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        // final ApiUser userDetails = new ApiUser( 0, userCreateRequest.getUsername(), "", "");
        Users userDetails = new Users( Long.valueOf(1), userCreateRequest.getUsername(), userCreateRequest.getPassword(), "ROLE_USER");

        return jwtTokenService.generateToken(userDetails);
    }

}
