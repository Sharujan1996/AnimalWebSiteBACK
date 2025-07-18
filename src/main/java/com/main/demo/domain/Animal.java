package com.main.demo.domain;

import java.util.ArrayList;
import java.util.List;

import com.main.demo.enums.RegimeAlimentaire;

public class Animal {
	
	private String nom_animal;
	
	private double poids;
	
	private double taille;
	
	private int esperance_de_vie;
	
	private String description_animal;
	
	private String photo_url;
	
	private String regime_alimentaire;
	
	private Espece espece;
	
	List<Habitat> habitats = new ArrayList<>();
	
	

	public Animal() {
		
	}
	

	public String getNom_animal() {
		return nom_animal;
	}

	public void setNom_animal(String nom_animal) {
		this.nom_animal = nom_animal;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public int getEsperance_de_vie() {
		return esperance_de_vie;
	}

	public void setEsperance_de_vie(int esperance_de_vie) {
		this.esperance_de_vie = esperance_de_vie;
	}

	public String getDescription_animal() {
		return description_animal;
	}

	public void setDescription_animal(String description_animal) {
		this.description_animal = description_animal;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getRegime_alimentaire() {
		return regime_alimentaire;
	}

	public void setRegime_alimentaire(String regime_alimentaire) {
		this.regime_alimentaire = regime_alimentaire;
	}

	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) {
		this.espece = espece;
	}

	public List<Habitat> getHabitats() {
		return habitats;
	}

	public void setHabitats(List<Habitat> habitats) {
		this.habitats = habitats;
	}


	@Override
	public String toString() {
		return "AnimalFullInfo [nom_animal=" + nom_animal + ", poids=" + poids + ", taille=" + taille
				+ ", esperance_de_vie=" + esperance_de_vie + ", description_animal=" + description_animal
				+ ", photo_url=" + photo_url + ", regime_alimentaire=" + regime_alimentaire + ", espece=" + espece
				+ ", habitats=" + habitats + "]";
	}
	
	
	
	
	

}
