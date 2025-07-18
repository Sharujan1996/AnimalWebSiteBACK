package com.main.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.main.demo.domain.Animal;
import com.main.demo.domain.Continent;
import com.main.demo.domain.Espece;
import com.main.demo.domain.Famille;
import com.main.demo.domain.Habitat;
import com.main.demo.entity.AnimalEntity;
import com.main.demo.entity.ContinentEntity;
import com.main.demo.entity.EspeceEntity;
import com.main.demo.entity.FamilleEntity;
import com.main.demo.entity.HabitatEntity;

public final class AnimalMapper {


	public static Animal entityToDomain(AnimalEntity animalEntity) {
		if(animalEntity == null) {
			return null;
		}

		Animal animal =  new Animal();
		animal.setNom_animal(animalEntity.getNom_animal());
		animal.setPoids(animalEntity.getPoids());
		animal.setTaille(animalEntity.getTaille());
		animal.setEsperance_de_vie(animalEntity.getEsperance_de_vie());
		animal.setDescription_animal(animalEntity.getDescription_animal());
		animal.setPhoto_url(animalEntity.getPhoto_url());
		animal.setRegime_alimentaire(animalEntity.getRegime_alimentaire()!= null? animalEntity.getRegime_alimentaire().getCode():null);

		if(animalEntity.getEspece()!= null) {
			animal.setEspece(mapEspece(animalEntity.getEspece()));

		}

		if(animalEntity.getHabitats()!= null && !animalEntity.getHabitats().isEmpty()) {
			List<Habitat> habitats = animalEntity.getHabitats().stream()
					.map(AnimalMapper::mapHabitats)
					.collect(Collectors.toList());
			animal.setHabitats(habitats);

		}

		return animal;
	}


	private static Espece mapEspece(EspeceEntity especeEntity) {
		if(especeEntity == null) {
			return null;
		}
		Espece espece = new Espece();
		espece.setNom_espece(especeEntity.getNom_espece());
		espece.setDescription_espece(especeEntity.getDescription_espece());
		espece.setFamille(mapFamille(especeEntity.getFamille()));

		return espece;
	}


	private static Famille mapFamille(FamilleEntity familleEntity) {
		if(familleEntity == null) {
			return null;
		}

		Famille famille = new Famille();
		famille.setNom_famille(familleEntity.getNom_famille());
		famille.setDescription_famille(familleEntity.getDescription_famille());
		return famille;
	}


	private static Habitat mapHabitats(HabitatEntity habitatEntity){
		if(habitatEntity == null) {
			return null;
		}

		Habitat habitat = new Habitat();
		habitat.setNom_habitat(habitatEntity.getNom_habitat());
		habitat.setContinent(mapContinent(habitatEntity.getContinentEntity()));
		return habitat;
	}


	private static Continent mapContinent(ContinentEntity continentEntity) {
		if(continentEntity == null) {
			return null;
		}

		Continent continent = new Continent();
		continent.setNom_continent(continentEntity.getNom_continent());
		return continent;
	}

}
