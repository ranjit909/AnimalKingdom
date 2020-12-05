package com.animal.AnimalKingdom.birds;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IBird;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "geese")
@DiscriminatorValue("Geese")
public class Geese extends Animal implements IBird  {
	
	public Geese() {
		super();
	}
	
    public Geese(Animal animal) {
		super(animal);
		fly();
	}

    @Override
    public void fly() {
        String className = this.getClass().getSimpleName();
        super.setFly("Fly like a " + className);
    }

}
