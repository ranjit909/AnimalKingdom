package com.animal.AnimalKingdom.mammals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IMammal;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "lion")
@DiscriminatorValue("Lion")
public class Lion extends Animal implements IMammal  {
	
	public Lion() {
		super();
	}
	
    public Lion(Animal animal) {
		super(animal);
		suckle();
	}

    @Override
    public void suckle() {
    	String className = this.getClass().getSimpleName();
    	super.setSuckle("Scule of " + className);
    }

}
