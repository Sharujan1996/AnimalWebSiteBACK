package com.main.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.demo.entity.FamilleEntity;

public interface FamilleRepository extends JpaRepository< FamilleEntity, Long>{
		
	@Query("SELECT DISTINCT f.nom_famille FROM FamilleEntity f")
	public List<String> findAllNomFamille();

}
