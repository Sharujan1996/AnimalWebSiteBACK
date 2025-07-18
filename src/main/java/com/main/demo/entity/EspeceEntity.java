package com.main.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESPECE")
public class EspeceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESPECE_ID")
	private Long espece_id;
	
	
	@Column(name = "NOM_ESPECE", nullable = false)
	private String nom_espece;
	
	
	@Column(name = "DESCRIPTION_ESPECE")
	private String description_espece;
	
	@ManyToOne
	@JoinColumn(name = "FAMILLE_ID" , referencedColumnName =  "FAMILLE_ID")
	private FamilleEntity famille;
	
	@OneToOne(mappedBy = "espece")
	private AnimalEntity animalEntity;
	
	

	public EspeceEntity() {
	}


	public Long getEspece_id() {
		return espece_id;
	}
	

	public void setEspece_id(Long espece_id) {
		this.espece_id = espece_id;
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

	
	public FamilleEntity getFamille() {
		return famille;
	}
	

	public void setFamille(FamilleEntity famille) {
		this.famille = famille;
	}
	
	

	public AnimalEntity getAnimalEntity() {
		return animalEntity;
	}


	public void setAnimalEntity(AnimalEntity animalEntity) {
		this.animalEntity = animalEntity;
	}


	@Override
	public String toString() {
		return "EspeceEntity [espece_id=" + espece_id + ", nom_espece=" + nom_espece + ", description_espece="
				+ description_espece + ", famille=" + famille + "]";
	}
	
		
	

}
