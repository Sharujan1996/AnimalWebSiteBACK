package com.main.demo.domain;

public class Habitat {
	
	private String nom_habitat;
	
	private Continent continent;

	
	public Habitat() {
		
	}


	public String getNom_habitat() {
		return nom_habitat;
	}


	public void setNom_habitat(String nom_habitat) {
		this.nom_habitat = nom_habitat;
	}


	public Continent getContinent() {
		return continent;
	}


	public void setContinent(Continent continent) {
		this.continent = continent;
	}


	@Override
	public String toString() {
		return "Habitat [nom_habitat=" + nom_habitat + ", continent=" + continent + "]";
	}
	
	
	

}
