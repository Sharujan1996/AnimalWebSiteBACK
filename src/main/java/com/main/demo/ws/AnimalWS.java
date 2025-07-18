package com.main.demo.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.demo.domain.Animal;
import com.main.demo.domain.FilterDataForAnimal;
import com.main.demo.service.AnimalService;

@RestController
@RequestMapping("/api/animal")
public class AnimalWS {

	@Autowired
	private AnimalService animalService;


	@GetMapping("/{nom_animal}")
	public Animal findAnimalFullInfoByName(@PathVariable String nom_animal) {
		return animalService.findAnimalFullInfoByName(nom_animal);
	}
	
	
	@GetMapping("/filter")
	public FilterDataForAnimal loadFilter() {
		return animalService.loadFilterOptions();
	}
	
	
	@PostMapping("/resultat_filtre")
	 public Page<Animal> searchResultByFilter(
			 @RequestBody FilterDataForAnimal filter,
			 @RequestParam(defaultValue = " 7") int page,
			 @RequestParam(defaultValue = "3") int size){
		 Pageable pageable = PageRequest.of(page, size);
		 return animalService.searchResultByFilter(filter, pageable);
				 
		
	}
	
	
	
	

}
