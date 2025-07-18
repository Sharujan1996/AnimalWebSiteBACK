package com.main.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HABITAT")
public class HabitatEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HABITAT_ID")
	private Long habitat_id;
	
	
	@Column(name = "NOM_HABITAT" , nullable = false)
	private String nom_habitat;
	
	@ManyToOne
	@JoinColumn(name = "CONTINENT_ID" , referencedColumnName = "CONTINENT_ID")
	private ContinentEntity continentEntity;
	
	@ManyToMany(mappedBy = "habitats")
	List<AnimalEntity> animals = new ArrayList<>();
	
	
	
	public HabitatEntity() {
	}

	
	
	public Long getHabitat_id() {
		return habitat_id;
	}

	public void setHabitat_id(Long habitat_id) {
		this.habitat_id = habitat_id;
	}

	public String getNom_habitat() {
		return nom_habitat;
	}

	public void setNom_habitat(String nom_habitat) {
		this.nom_habitat = nom_habitat;
	}

	public ContinentEntity getContinentEntity() {
		return continentEntity;
	}

	public void setContinentEntity(ContinentEntity continentEntity) {
		this.continentEntity = continentEntity;
	}

	public List<AnimalEntity> getAnimals() {
		return animals;
	}

	public void setAnimals(List<AnimalEntity> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "HabitatEntity [habitat_id=" + habitat_id + ", nom_habitat=" + nom_habitat + ", continentEntity="
				+ continentEntity + ", animals=" + animals + "]";
	}
	
	
	

}
