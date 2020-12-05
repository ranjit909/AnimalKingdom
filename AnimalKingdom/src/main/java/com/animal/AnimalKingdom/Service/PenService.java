package com.animal.AnimalKingdom.Service;

import java.util.List;

import com.animal.AnimalKingdom.zoo.Pens;

public interface PenService {
	public  List<Pens> loadAllPens();

	public boolean savePen(Pens penInput);
}
