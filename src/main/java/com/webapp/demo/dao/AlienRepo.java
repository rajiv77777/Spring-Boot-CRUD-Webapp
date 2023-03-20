package com.webapp.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.webapp.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	/*
	 * Defining the Queries for controller Syso
	List<Alien> findByName(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where name=?1 order by name")
	List<Alien> findByNameSorted(String name);
	
	*/
}
