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
@Table(name = "FAMILLE")
public class FamilleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FAMILLE_ID")
	private Long famille_id;

	
	@Column(name = "NOM_FAMILLE" , nullable = false)
	private String nom_famille;
	
	
	@Column(name = "DESCRIPTION_FAMILLE")
	private String description_famille;
	
	@OneToMany(mappedBy = "famille")
	List<EspeceEntity> especes = new ArrayList<>();
	
	

	public FamilleEntity() {
	}
	
	

	public Long getFamille_id() {
		return famille_id;
	}

	public void setFamille_id(Long famille_id) {
		this.famille_id = famille_id;
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
	
	

	public List<EspeceEntity> getEspeces() {
		return especes;
	}
	

	public void setEspeces(List<EspeceEntity> especes) {
		this.especes = especes;
	}

	
	@Override
	public String toString() {
		return "FamilleEntity [famille_id=" + famille_id + ", nom_famille=" + nom_famille + ", description_famille="
				+ description_famille + ", especes=" + especes + "]";
	}
	
	
	
	
}
