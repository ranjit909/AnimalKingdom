package com.animal.AnimalKingdom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animal.AnimalKingdom.zoo.Zoo;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, Long>{

	Zoo save(Zoo entity); 
	
	void delete(Zoo entity);

	List<Zoo> findAll();

}
