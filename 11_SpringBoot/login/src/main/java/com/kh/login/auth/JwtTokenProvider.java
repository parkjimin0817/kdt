package com.kh.login.auth;

import com.kh.login.enums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final int expiration;
    private final Key SECRET_KEY;

    public JwtTokenProvider(@Value("${jwt.secret}")String secretKey, @Value("${jwt.expiration}") int expiration) {
        this.secretKey = secretKey;
        this.expiration = expiration;
        this.SECRET_KEY = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    }

    public String createToken(String email, String role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role", role);

        Date now = new Date();
        Date expire = new Date(now.getTime() + (expiration * 1000L * 60));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUserEmailFromToken(){
        //
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
