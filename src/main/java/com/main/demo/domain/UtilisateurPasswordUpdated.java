package com.main.demo.domain;

public class UtilisateurPasswordUpdated {
	
	private String email;
	private String motDePasse;
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	@Override
	public String toString() {
		return "UtilisateurPasswordUpdated [email=" + email + ", motDePasse=" + motDePasse + "]";
	}
	
	
	
}
