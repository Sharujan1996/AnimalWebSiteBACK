package com.main.demo.mapper;

import java.util.List;

import com.main.demo.domain.FilterDataForAnimal;

public final class FilterDataMapper {
	
	
	public static FilterDataForAnimal mapToFilterDataForAnimal(
			List<String> nomEspeces, 
			List<String> nomHabitats, 
			List<String> nomFamilles,
			List<String> nomContinents, 
			List<String> regimesAlimentaires)               {
		
		FilterDataForAnimal filterDataForAnimal = new FilterDataForAnimal();
		filterDataForAnimal.setNom_especes(nomEspeces);
		filterDataForAnimal.setNom_continents(nomContinents);
		filterDataForAnimal.setNom_habitats(nomHabitats);
		filterDataForAnimal.setRegimeAlimentaire(regimesAlimentaires);
		filterDataForAnimal.setNom_familles(nomFamilles);
		return filterDataForAnimal;
		
	}

}
