package com.animal.AnimalKingdom.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.animal.AnimalKingdom.Repository.PenRepository;
import com.animal.AnimalKingdom.zoo.Pens;

@Service
@Component
@Transactional
public class PenServiceImpl implements PenService{

	@Autowired
	protected PenRepository penRepository;
	
	@Override
	public List<Pens> loadAllPens() {
		return penRepository.findAll();
	}

	@Override
	public boolean savePen(Pens penInput) {
		Pens pens=penRepository.save(penInput);
		return pens!=null?true:false;
	}

}
