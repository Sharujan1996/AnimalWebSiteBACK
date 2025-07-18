package com.main.demo.domain;

public class Continent {

	private String nom_continent;
	
	
	public Continent() {
		
	}

	public String getNom_continent() {
		return nom_continent;
	}

	public void setNom_continent(String nom_continent) {
		this.nom_continent = nom_continent;
	}

	@Override
	public String toString() {
		return "Continent [nom_continent=" + nom_continent + "]";
	}
	
	
	
	
}
