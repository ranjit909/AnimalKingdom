package com.animal.AnimalKingdom.mammals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.animal.AnimalKingdom.Interfaces.IMammal;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "wolve")
@DiscriminatorValue("Wolve")
public class Wolve extends Animal implements IMammal{
	
	public Wolve() {
		super();
	}
    public Wolve(Animal animal) {
		super(animal);
		suckle();
	}
    
    @Override
    public void suckle() {
    	String className = this.getClass().getSimpleName();
    	super.setSuckle("Scule of " + className);
    }

}
