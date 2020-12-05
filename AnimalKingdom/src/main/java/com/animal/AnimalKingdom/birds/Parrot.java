package com.animal.AnimalKingdom.birds;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IBird;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "parrot")
@DiscriminatorValue("Parrot")
public class Parrot extends Animal implements IBird {

	public Parrot() {
		super();
	}
	
    public Parrot(Animal animal) {
		super(animal);
		fly();
	}

    @Override
    public void fly() {
        String className = this.getClass().getSimpleName();
        super.setFly("Fly like a " + className);
    }

}




