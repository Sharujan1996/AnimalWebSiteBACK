package com.main.demo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.demo.domain.Utilisateur;
import com.main.demo.domain.UtilisateurPasswordUpdated;
import com.main.demo.domain.UtilisateurUpdated;
import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.exception.RepositoryException;
import com.main.demo.mapper.UtilisateurMapper;
import com.main.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
    private final static Logger LOGGER = LoggerFactory.getLogger(Utilisateur.class);
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	/**
	 * supprimer un utilisateur en fonction de son id 
	 * @param id
	 */
	public void deleteUser(Long id) {
		try {
		   utilisateurRepository.deleteById(id);
		} catch (DataAccessException e){
			throw new RepositoryException("Erreur technique lors de la suppression de l'utilisateur avec l'ID : \" + id", e);
		}
	}
	
	
	/**
	 * mettre à jour un utilisateur en fonction de son id
	 * @param id
	 */
	public Utilisateur updateUser(Long id , UtilisateurUpdated utilisateur) {
		try {
		  UtilisateurEntity utilisateurEntity =  utilisateurRepository.getById(id);
		  UtilisateurMapper.domainToEntityForUpdate(utilisateur , utilisateurEntity);
		  System.out.println("utilisateur : " +utilisateurEntity);
		  UtilisateurEntity updateEntity = utilisateurRepository.save(utilisateurEntity);
		  return UtilisateurMapper.entityToDomain(updateEntity);		
		} catch(DataAccessException e) {
			throw new RepositoryException("Erreur technique lors de la mise à jour de l'utilisateur avec l'ID : \" + id", e);
		}
	}
	
	
	
	/**
	 * prendre les données utilisateurs en fonction du id 
	 * @param id
	 * @return
	 */
	public UtilisateurEntity getUser(Long id) {
		try {
		   return utilisateurRepository.getById(id);
		} catch(DataAccessException e) {
			throw new RepositoryException("Erreur technique lors de la recherche de l'utilisateur avec l'ID : \" + id", e);
		}
	}
	
	
	public boolean isUpdated(UtilisateurPasswordUpdated utilisateur) {
		try {
		  Optional<UtilisateurEntity> utilisateurEntity = utilisateurRepository.findByEmail(utilisateur.getEmail());
		  if(utilisateurEntity.isPresent()) {
			 UtilisateurEntity op = utilisateurEntity.get();
			 String hash = encoder.encode(utilisateur.getMotDePasse());
			 op.setMotDePasse(hash);
			 utilisateurRepository.save(op);
			 return true;
		  }
		     return false;
		
	    } catch(Exception e) {
	    	LOGGER.error("erreur lors de la mise à jour du mot de passe avec l'email : " +utilisateur.getEmail() , e);
	        return false;
	    }
	
	}
}
