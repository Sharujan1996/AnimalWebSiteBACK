package com.main.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.main.demo.domain.Utilisateur;
import com.main.demo.entity.UtilisateurEntity;
import com.main.demo.exception.RepositoryException;
import com.main.demo.mapper.UtilisateurMapper;
import com.main.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
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
	public Utilisateur updateUser(Long id , Utilisateur utilisateur) {
		try {
		  UtilisateurEntity utilisateurEntity =  utilisateurRepository.getById(id);
		  utilisateurEntity = UtilisateurMapper.domainToEntity(utilisateur);
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

}
