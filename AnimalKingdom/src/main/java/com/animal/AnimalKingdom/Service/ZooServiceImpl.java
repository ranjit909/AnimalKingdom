package com.animal.AnimalKingdom.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.animal.AnimalKingdom.Repository.ZooRepository;
import com.animal.AnimalKingdom.zoo.Zoo;

@Service
@Component
@Transactional
public class ZooServiceImpl implements ZooService{

	@Autowired
	ZooRepository zooRepository;
	
	@Override
	public List<Zoo> loadAllZoos() {
		return zooRepository.findAll();
	}

	@Override
	public boolean saveZoo(Zoo zoo) {
		Zoo zoo2=zooRepository.save(zoo);
		return zoo2!=null?true:false;
	}

	@Override
	public Optional<Zoo> findById(Long id) {
		return zooRepository.findById(id);
	}

}
