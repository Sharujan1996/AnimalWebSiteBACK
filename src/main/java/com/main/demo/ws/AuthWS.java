package com.main.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.demo.domain.JwtAuthResponse;
import com.main.demo.domain.LoginInfo;
import com.main.demo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthWS {
	
	 @Autowired
	 private AuthService authService;

	    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginInfo login) {
	        String jwt = authService.login(login.getEmail(), login.getMotDePasse());
	        return ResponseEntity.ok(new JwtAuthResponse(jwt, "Bearer"));
	    }
	}


