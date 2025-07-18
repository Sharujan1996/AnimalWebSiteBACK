package com.main.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.demo.entity.ContinentEntity;


public interface ContinentRepository extends JpaRepository< ContinentEntity, Long> {
	
	@Query("SELECT DISTINCT c.nom_continent FROM ContinentEntity c")
	public List<String> findAllNomContinent();
		
	

}
