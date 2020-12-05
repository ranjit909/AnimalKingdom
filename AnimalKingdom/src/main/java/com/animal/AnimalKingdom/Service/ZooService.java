package com.animal.AnimalKingdom.Service;

import java.util.List;
import java.util.Optional;

import com.animal.AnimalKingdom.zoo.Zoo;

public interface ZooService {
	
	public  List<Zoo> loadAllZoos();
	public boolean saveZoo(Zoo penInput);
	public Optional<Zoo> findById(Long id); 
	
}
