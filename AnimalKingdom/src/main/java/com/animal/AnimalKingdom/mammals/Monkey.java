package com.animal.AnimalKingdom.mammals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.animal.AnimalKingdom.Interfaces.IMammal;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "monkey")
@DiscriminatorValue("Monkey")
public class Monkey extends Animal implements IMammal{
	
	public Monkey() {
		super();
	}
    public Monkey(Animal animal) {
		super(animal);
		suckle();
	}
    
    @Override
    public void suckle() {
    	String className = this.getClass().getSimpleName();
    	super.setSuckle("Scule of " + className);
    }

}
