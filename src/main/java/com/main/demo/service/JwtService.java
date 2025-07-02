package com.main.demo.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	 @Value("${app.jwtSecret}")
	  private String jwtSecret;
	    
	 @Value("${app.jwtExpirationMs}")
	  private int jwtExpMs;

	  private SecretKey getSigningKey() {
	     return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSecret));
	  }

	  public String generateToken(String username) {
	     SecretKey key = getSigningKey();
	     return Jwts.builder()
	             .setSubject(username)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + jwtExpMs))
	            .signWith(key)
	            .compact();
	  }

	  public String extractUsername(String token) {
	      Claims claims = Jwts.parserBuilder()
	            .setSigningKey(getSigningKey())
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	        return claims.getSubject();
	    }
	  

	   public boolean isTokenValid(String token, UserDetails userDetails) {
	        try {
	            Claims claims = Jwts.parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();

	            return claims.getSubject().equals(userDetails.getUsername())
	                && claims.getExpiration().after(new Date());
	        } catch (JwtException e) {
	            return false;
	        }
	    }
	

}
