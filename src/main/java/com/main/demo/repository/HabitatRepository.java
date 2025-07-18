package com.main.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.demo.entity.HabitatEntity;

public interface HabitatRepository extends JpaRepository< HabitatEntity, Long> {
	
	
	@Query("SELECT DISTINCT h.nom_habitat FROM HabitatEntity h")
	public List<String> findAllHabitat();

}
