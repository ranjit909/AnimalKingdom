package com.animal.AnimalKingdom.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.animal.AnimalKingdom.Repository.AnimalRepository;
import com.animal.AnimalKingdom.general.Animal;

@Service
@Component
@Transactional
public class AnimalServiceImpl implements AnimalService{
	@Autowired
	protected AnimalRepository animalRepository;
	
	@Override
	public List<Animal> loadAllAnimals() {
		return animalRepository.findAll();
	}

	@Override
	public boolean save(Animal animalInput) {
		Animal animal=animalRepository.save(animalInput);
		return animal!=null?true:false;
	}

	@Override
	public Optional<Animal> findAnimalByID(Long id) {
		return animalRepository.findById(id);
	}

	@Override
	public void deleteAnimal(Animal animal) {
		animalRepository.delete(animal);
	}

}
