package com.main.demo.mapper;

import com.main.demo.domain.Utilisateur;
import com.main.demo.entity.UtilisateurEntity;

public final class UtilisateurMapper {
	
	
	public static Utilisateur entityToDomain(UtilisateurEntity entity) {
		if(entity == null) {
			return null;
		}
		
		Utilisateur domain = new Utilisateur();
		domain.setNom(entity.getNom());
		domain.setPrenom(entity.getPrenom());
		domain.setEmail(entity.getEmail());
		domain.setSexe(entity.getSexe());
		domain.setTelephone(entity.getTelephone()!=null ? entity.getTelephone():null);
		domain.setMotDePasse(entity.getMotDePasse());
		domain.setDateDeNaissance(entity.getDateDeNaissance());
		return domain;
	}
	
	
	public static UtilisateurEntity domainToEntity(Utilisateur domain) {
		if(domain == null) {
			return null;
		}
		UtilisateurEntity entity = new UtilisateurEntity();
		entity.setNom(domain.getNom());
		entity.setPrenom(domain.getPrenom());
		entity.setEmail(domain.getEmail());
		entity.setSexe(domain.getSexe());
		entity.setTelephone(domain.getTelephone()!=null ? domain.getTelephone():null);
		entity.setMotDePasse(domain.getMotDePasse());
		entity.setDateDeNaissance(domain.getDateDeNaissance());
		return entity;
	}
	
	
	
	public static UtilisateurEntity domainToEntity(Utilisateur domain , String hash) {
		if(domain == null) {
			return null;
		}
		UtilisateurEntity entity = new UtilisateurEntity();
		entity.setNom(domain.getNom());
		entity.setPrenom(domain.getPrenom());
		entity.setEmail(domain.getEmail());
		entity.setSexe(domain.getSexe());
		entity.setTelephone(domain.getTelephone()!=null ? domain.getTelephone():null);
		entity.setMotDePasse(hash);
		entity.setDateDeNaissance(domain.getDateDeNaissance());
		return entity;
	}

}
