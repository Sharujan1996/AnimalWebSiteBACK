package com.main.demo.domain;

import java.util.List;

public class FilterDataForAnimal {

	List<String> regimeAlimentaire;
	List<String> nom_familles;
	List<String> nom_habitats;
	List<String> nom_continents;
	List<String> nom_especes;

	public FilterDataForAnimal() {

	}

	public List<String> getRegimeAlimentaire() {
		return regimeAlimentaire;
	}

	public void setRegimeAlimentaire(List<String> regimeAlimentaire) {
		this.regimeAlimentaire = regimeAlimentaire;
	}

	public List<String> getNom_familles() {
		return nom_familles;
	}

	public void setNom_familles(List<String> nom_familles) {
		this.nom_familles = nom_familles;
	}

	public List<String> getNom_habitats() {
		return nom_habitats;
	}

	public void setNom_habitats(List<String> nom_habitats) {
		this.nom_habitats = nom_habitats;
	}

	public List<String> getNom_continents() {
		return nom_continents;
	}

	public void setNom_continents(List<String> nom_continents) {
		this.nom_continents = nom_continents;
	}

	public List<String> getNom_especes() {
		return nom_especes;
	}

	public void setNom_especes(List<String> nom_especes) {
		this.nom_especes = nom_especes;
	}

	@Override
	public String toString() {
		return "FilterDataForAnimal [regimeAlimentaire=" + regimeAlimentaire + ", nom_familles=" + nom_familles
				+ ", nom_habitats=" + nom_habitats + ", nom_continents=" + nom_continents + ", nom_especes="
				+ nom_especes + "]";
	}
		

}
