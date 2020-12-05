package com.animal.AnimalKingdom.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.animal.AnimalKingdom.general.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	Animal save(Animal entity); 
	
	void delete(Animal entity);

	List<Animal> findAll();

}
