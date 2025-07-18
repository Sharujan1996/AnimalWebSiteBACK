package com.main.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTINENT")
public class ContinentEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "CONTINENT_ID")
	private Long continent_id;
	
	
	@Column(name = "NOM_CONTINENT" , nullable = false)
	private String nom_continent;
	
	
	@OneToMany(mappedBy = "continentEntity")
	private List<HabitatEntity> habitats = new ArrayList<>();
	


	public ContinentEntity() {
		
	}


	public Long getContinent_id() {
		return continent_id;
	}


	public void setContinent_id(Long continent_id) {
		this.continent_id = continent_id;
	}


	public String getNom_continent() {
		return nom_continent;
	}


	public void setNom_continent(String nom_continent) {
		this.nom_continent = nom_continent;
	}


	public List<HabitatEntity> getHabitats() {
		return habitats;
	}


	public void setHabitats(List<HabitatEntity> habitats) {
		this.habitats = habitats;
	}


	@Override
	public String toString() {
		return "ContinentEntity [continent_id=" + continent_id + ", continent_nom=" + nom_continent + ", habitats="
				+ habitats + "]";
	}
	
	
	

}
