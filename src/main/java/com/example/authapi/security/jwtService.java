package com.example.authapi.security;

import org.springframework.beans.factory.annotation.Value;

public class jwtService {
    
    @Value("jwt.secret")
    private String secretKey;

}
