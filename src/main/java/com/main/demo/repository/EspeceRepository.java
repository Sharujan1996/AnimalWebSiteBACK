package com.main.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.demo.entity.EspeceEntity;

public interface EspeceRepository extends JpaRepository< EspeceEntity, Long> {
	
	@Query("SELECT DISTINCT e.nom_espece FROM EspeceEntity e")
	public List<String> findAllNomEspece();

}
