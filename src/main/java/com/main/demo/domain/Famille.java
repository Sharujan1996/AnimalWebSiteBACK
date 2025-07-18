package com.main.demo.domain;

public class Famille {
	
	private String nom_famille;
	
	private String description_famille;

	
	
	public Famille() {
		super();
	}



	public String getNom_famille() {
		return nom_famille;
	}



	public void setNom_famille(String nom_famille) {
		this.nom_famille = nom_famille;
	}



	public String getDescription_famille() {
		return description_famille;
	}



	public void setDescription_famille(String description_famille) {
		this.description_famille = description_famille;
	}



	@Override
	public String toString() {
		return "Famille [nom_famille=" + nom_famille + ", description_famille=" + description_famille + "]";
	}
	
	
	
	
	

}
