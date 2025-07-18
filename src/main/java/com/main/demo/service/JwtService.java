package com.main.demo.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.main.demo.entity.UtilisateurEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
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

	public String generateToken(UtilisateurEntity utilisateurEntity) {
		SecretKey key = getSigningKey();
		String token = Jwts.builder()
				.setSubject(utilisateurEntity.getEmail())
				.claim("id" , utilisateurEntity.getId())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpMs))
				.signWith(key)
				.compact();

		System.out.println("JWT généré avec claim id : " + token);
		return token;
	}

	public String extractUsername(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(getSigningKey())
					.build()
					.parseClaimsJws(token)
					.getBody();
			return claims.getSubject();
		} catch(ExpiredJwtException e) {
			System.out.println("Token expiré !");
			return null;
		} catch (JwtException e) {
			// Autres erreurs de parsing
			return null;
		}
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
