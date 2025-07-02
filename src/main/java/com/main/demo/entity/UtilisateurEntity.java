package com.main.demo.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class UtilisateurEntity {
	
	public UtilisateurEntity() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@SequenceGenerator(name = "client_seq", sequenceName = "client_sequence", allocationSize = 1)
	private Long id;

	
	@Column(name = "NOM" , nullable = false)
	private String nom;
	
	@Column(name = "PRENOM" , nullable = false)
	private String prenom;
		
	@Column(name = "EMAIL" , nullable = false)
	private String email;	
	
	@Column(name = "SEXE" , length = 1)
	private String sexe;	
	
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "DATEBIRTH" )
	private LocalDate dateDeNaissance;
	
	@Column(name = "PASSWORD" , nullable = false)
	private String motDePasse;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
		
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "UtilisateurEntity [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", sexe="
				+ sexe + ", telephone=" + telephone + ", date_de_naissance=" + dateDeNaissance + ", mot_de_passe="
				+ motDePasse + "]";
	}
	
	
	
	
	
}
