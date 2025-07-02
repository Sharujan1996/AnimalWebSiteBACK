package com.main.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.exception.RepositoryException;
import com.main.demo.repository.UtilisateurRepository;

@Service
public class CustomUtilisateurDetailService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       try {
           UtilisateurEntity u = utilisateurRepository.findByEmail(username)
             .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));
            return org.springframework.security.core.userdetails.User
               .withUsername(u.getEmail())
               .password(u.getMotDePasse())
               .authorities("ROLE_USER") // adapte selon ton cas
               .build();
       } catch (DataAccessException e) {
           // En cas d'erreur technique liée à la base
               throw new RepositoryException("Erreur technique lors de la recherche de l'utilisateur : " + username, e);
      }
    }
}


