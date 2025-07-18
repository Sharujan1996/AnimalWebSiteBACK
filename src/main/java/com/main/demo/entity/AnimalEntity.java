package com.main.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.main.demo.enums.RegimeAlimentaire;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class AnimalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANIMAL_ID")
	private Long animal_id;
	
	@Column(name = "NOM_ANIMAL" ,  nullable = false)
	private String nom_animal;
	
	@Column(name = "POIDS")
	private double poids;
	
	@Column(name = "TAILLE")
	private double taille;
	
	@Column(name = "ESPERANCE_DE_VIE")
	private int esperance_de_vie;
	
	
	@Column(name = "DESCRIPTION_ANIMAL")
	private String description_animal;
	
	@Column(name = "PHOTO_URL")
	private String photo_url;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "REGIME_ALIMENTAIRE", length = 1)
	private RegimeAlimentaire regime_alimentaire;
	
	@OneToOne
	@JoinColumn(name = "ESPECE_ID", referencedColumnName = "ESPECE_ID")
	private EspeceEntity espece;
	
	
	@ManyToMany
	@JoinTable(name = "ANIMAL_HABITAT" , 
	           joinColumns = @JoinColumn(name = "ANIMAL_ID"),
	           inverseJoinColumns = @JoinColumn(name = "HABITAT_ID"))
	 List<HabitatEntity> habitats = new ArrayList<>();
	
	
	
	public AnimalEntity() {
		
	}

	

	public Long getAnimal_id() {
		return animal_id;
	}
	

	public void setAnimal_id(Long animal_id) {
		this.animal_id = animal_id;
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
	

	public RegimeAlimentaire getRegime_alimentaire() {
		return regime_alimentaire;
	}
	

	public void setRegime_alimentaire(RegimeAlimentaire regime_alimentaire) {
		this.regime_alimentaire = regime_alimentaire;
	}
	

	public EspeceEntity getEspece() {
		return espece;
	}
	

	public void setEspece(EspeceEntity espece) {
		this.espece = espece;
	}
	
	

	public List<HabitatEntity> getHabitats() {
		return habitats;
	}


	public void setHabitats(List<HabitatEntity> habitats) {
		this.habitats = habitats;
	}


	@Override
	public String toString() {
		return "AnimalEntity [animal_id=" + animal_id + ", nom_animal=" + nom_animal + ", poids=" + poids + ", taille="
				+ taille + ", esperance_de_vie=" + esperance_de_vie + ", description_animal=" + description_animal
				+ ", photo_url=" + photo_url + ", regime_alimentaire=" + regime_alimentaire + ", espece=" + espece
				+ ", habitats=" + habitats + "]";
	}
	

}
