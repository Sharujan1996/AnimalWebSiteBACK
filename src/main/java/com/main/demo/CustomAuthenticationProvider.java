package com.main.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.repository.UtilisateurRepository;


public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public CustomAuthenticationProvider(UtilisateurRepository utilisateurRepository, PasswordEncoder encoder) {
	    this.utilisateurRepository = utilisateurRepository;
	    this.encoder = encoder;
	  }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String email = authentication.getName();
        String pw = authentication.getCredentials().toString();
        UtilisateurEntity u = utilisateurRepository.findByEmail(email)
            .filter(user -> encoder.matches(pw, user.getMotDePasse()))
            .orElseThrow(() -> new BadCredentialsException("Email ou mot de passe incorrect"));

        List<GrantedAuthority> auths = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(email, null, auths);
    }

    @Override
    public boolean supports(Class<?> auth) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth);
    }
}


