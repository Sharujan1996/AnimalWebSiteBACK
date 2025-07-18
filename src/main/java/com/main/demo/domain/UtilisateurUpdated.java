package com.main.demo.domain;

public class UtilisateurUpdated {

	private String nom;
	private String prenom;
	private String telephone;
	private String sexe;
	
	
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
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "UtilisateurUpdated [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", sexe=" + sexe
				+ "]";
	}
	
	
	
	
}
