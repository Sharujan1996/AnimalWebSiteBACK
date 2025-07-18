package com.main.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.demo.entity.AnimalEntity;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
	
	
	@Query("SELECT a FROM AnimalEntity a "
			+ " JOIN FETCH a.espece e JOIN FETCH e.famille f "
			+ "JOIN FETCH a.habitats h JOIN FETCH h.continentEntity c WHERE LOWER(a.nom_animal) = LOWER(:nom_animal)")
	public Optional<AnimalEntity> findFullInfoAnimalByNomAnimal(@Param("nom_animal")String nom_animal);
		
	
	@Query("SELECT a FROM AnimalEntity a "
			+ " JOIN FETCH a.espece e JOIN FETCH e.famille f "
			+ " JOIN FETCH a.habitats h JOIN FETCH h.continentEntity c"
			+ " WHERE (:continents IS NULL OR c.nom_continent IN :continents)"
			+ " AND (:habitats IS NULL OR h.nom_habitat IN :habitats)"
			+ " AND (:familles IS NULL OR f.nom_famille IN :familles)"
			+ " AND (:especes IS NULL OR e.nom_espece IN :especes )"
			+ " AND (:regimeAlimentaires IS NULL OR a.regime_alimentaire IN :regimeAlimentaires)")
	public Page<AnimalEntity> findAnimalPaginatedByFilter(
			@Param("continents") List<String> continents, 
			@Param("habitats") List<String> habitats,
			@Param("especes") List<String> especes,
			@Param("familles") List<String> familles,
			@Param("regimeAlimentaires") List<String> regimeAlimentaires, Pageable page);
		
	
}
