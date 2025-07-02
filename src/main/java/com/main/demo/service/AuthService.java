package com.main.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.exception.RepositoryException;
import com.main.demo.repository.UtilisateurRepository;

@Service
public class AuthService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
    private  PasswordEncoder encoder;
	
	@Autowired
    private JwtService jwtService;

    public String login(String email, String motDePasse) {
    	try {
          UtilisateurEntity u = utilisateurRepository.findByEmail(email)
            .filter(user -> encoder.matches(motDePasse, user.getMotDePasse()))
            .orElseThrow(() -> new BadCredentialsException("Email ou mot de passe incorrect"));

              // On peut stocker des rôles ici si besoin
              return jwtService.generateToken(email);
              
        } catch (DataAccessException e) {
    	      throw new RepositoryException("Erreur d'accès au repository pour l'email : " + email, e);
        }
    }
}
