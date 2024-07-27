package com.example.escuela.services;


import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceI {
    String getToken(UserDetails userDetails);
    String getUserNameFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
