package com.animal.AnimalKingdom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animal.AnimalKingdom.zoo.Pens;

@Repository
public interface PenRepository extends JpaRepository<Pens, Long>{

	Pens save(Pens entity); 
	
	void delete(Pens entity);

	List<Pens> findAll();

}
