package com.taskmanager.userservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "f43b9a0607bfbeba26ed99843ce2e091b03fac02ab565203b8669e39aa3a62869b6e7843c0a96ac4456fa31b5a1c518aeb150a9e124e67835d0179cb675977bb1fbbe2dad9b24937353da54c0a96287f5ef74a413643c9ed7ae773d51e0e2b711c5c3404a4d1c7ebf9226238c1a3efc1036aed4de0d967e5547c4c2b61e93134";

    public String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 864_000_00))
                .signWith(key)
                .compact();
    }
}
