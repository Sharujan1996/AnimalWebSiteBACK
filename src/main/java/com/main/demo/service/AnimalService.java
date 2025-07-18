package com.main.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.main.demo.domain.Animal;
import com.main.demo.domain.FilterDataForAnimal;
import com.main.demo.entity.AnimalEntity;
import com.main.demo.enums.RegimeAlimentaire;
import com.main.demo.exception.RepositoryException;
import com.main.demo.mapper.AnimalMapper;
import com.main.demo.mapper.FilterDataMapper;
import com.main.demo.repository.AnimalRepository;
import com.main.demo.repository.ContinentRepository;
import com.main.demo.repository.EspeceRepository;
import com.main.demo.repository.FamilleRepository;
import com.main.demo.repository.HabitatRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private EspeceRepository especeRepository;

	@Autowired
	private ContinentRepository continentRepository;

	@Autowired
	private FamilleRepository familleRepository;

	@Autowired
	private HabitatRepository habitatRepository;

	public Animal findAnimalFullInfoByName(String nom_animal) {
		try {
			Optional<AnimalEntity> animalEntity = animalRepository.findFullInfoAnimalByNomAnimal(nom_animal);
			if (animalEntity.isPresent()) {
				return AnimalMapper.entityToDomain(animalEntity.get());
			} else {
				System.out.println("Animal non trouvé");
			}

		} catch (DataAccessException e) {
			throw new RepositoryException("Erreur lors de la recheche de l'animal : " + nom_animal, e);
		}
		return null;

	}

	public FilterDataForAnimal loadFilterOptions() {
		try {
			List<String> nomEspeces = especeRepository.findAllNomEspece();
			List<String> nomHabitats = habitatRepository.findAllHabitat();
			List<String> nomFamilles = familleRepository.findAllNomFamille();
			List<String> nomContinents = continentRepository.findAllNomContinent();
			List<String> regimesAlimentaires = Arrays.stream(RegimeAlimentaire.values()).map(t -> t.getCode())
					.collect(Collectors.toList());

			if (nomEspeces != null && !nomEspeces.isEmpty() && nomHabitats != null && !nomHabitats.isEmpty()
					&& nomContinents != null && !nomContinents.isEmpty() && nomFamilles != null
					&& !nomFamilles.isEmpty()) {

				return FilterDataMapper.mapToFilterDataForAnimal(nomEspeces, nomHabitats, nomFamilles, nomContinents,
						regimesAlimentaires);
			}

		} catch (DataAccessException e) {
			throw new RepositoryException("Erreur lors du chargement des données pour filtre", e);
		}
		return null;
	}
	

	public Page<Animal> searchResultByFilter(FilterDataForAnimal filter, Pageable pageable) {
	    Page<AnimalEntity> pages = animalRepository.findAnimalPaginatedByFilter(
	        filter.getNom_continents(),
	        filter.getNom_habitats(),
	        filter.getNom_especes(),
	        filter.getNom_familles(),
	        filter.getRegimeAlimentaire(),
	        pageable
	    );

	    List<Animal> animals = pages.stream()
	        .map(AnimalMapper::entityToDomain)
	        .collect(Collectors.toList());

	    return new PageImpl<Animal>(animals, pageable, pages.getTotalElements());
	}
}
