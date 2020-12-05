package com.animal.AnimalKingdom.Service;

import java.util.List;
import java.util.Optional;

import com.animal.AnimalKingdom.general.Animal;

public interface AnimalService {
	public  List<Animal> loadAllAnimals();

	public boolean save(Animal animalInput);
	
	public  Optional<Animal> findAnimalByID(Long id);

	public void deleteAnimal(Animal animal);
}
