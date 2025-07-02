package com.main.demo.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.demo.domain.Utilisateur;
import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.mapper.UtilisateurMapper;
import com.main.demo.repository.UtilisateurRepository;
import com.main.demo.service.UtilisateurService;


@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurWS {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/{id}")
	public Utilisateur getUserById(@PathVariable Long id) {
		return UtilisateurMapper.entityToDomain(utilisateurService.getUser(id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		utilisateurService.deleteUser(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody Utilisateur utilisateur) {
		  if(utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
			  return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message" , "Email dèjà Existant"));
		  }
		  String hash = encoder.encode(utilisateur.getMotDePasse());
		  UtilisateurEntity utilisateurEntity = UtilisateurMapper.domainToEntity(utilisateur , hash);
		  UtilisateurEntity savedEntity = utilisateurRepository.save(utilisateurEntity);
		  Utilisateur userSaved = UtilisateurMapper.entityToDomain(savedEntity);
		  return ResponseEntity.status(HttpStatus.OK).body(userSaved);
	}
	
	@PutMapping("/{id}")
     public Utilisateur updateUser(@PathVariable Long id , @RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUser(id, utilisateur);
	}
}
