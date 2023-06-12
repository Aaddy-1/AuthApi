package com.example.authapi.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.authapi.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class jwtService {
    
    @Value("jwt.secret")
    private String secretKey;

    public String generateToken(User user) {

        return Jwts.builder()
        .setSubject(user.getFirstName()) //  We set the subject to the users first name
        .setIssuedAt(new Date()) // We issue it at the current time
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // We set the expiration to be after 24 hours
        .signWith(SignatureAlgorithm.HS512, secretKey) // We sign it using a hashing algorithm and our secretkey
        .compact();
    }

    // public boolean validateToken(String token) {

    // }
}
