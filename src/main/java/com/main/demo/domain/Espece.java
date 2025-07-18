package com.main.demo.domain;

public class Espece {
	
	private String nom_espece;
	
	private String description_espece;
	
	private Famille famille;
		

	public Espece() {
	
	}
	
	

	public String getNom_espece() {
		return nom_espece;
	}

	public void setNom_espece(String nom_espece) {
		this.nom_espece = nom_espece;
	}

	public String getDescription_espece() {
		return description_espece;
	}

	public void setDescription_espece(String description_espece) {
		this.description_espece = description_espece;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}



	@Override
	public String toString() {
		return "Espece [nom_espece=" + nom_espece + ", description_espece=" + description_espece + ", famille="
				+ famille + "]";
	}
	
	
	

}
