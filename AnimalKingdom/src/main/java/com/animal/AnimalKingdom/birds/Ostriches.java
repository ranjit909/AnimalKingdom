package com.animal.AnimalKingdom.birds;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IBird;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "ostriches")
@DiscriminatorValue("Ostriches")
public class Ostriches extends Animal implements IBird  {
	
	public Ostriches() {
		super();
	}
    public Ostriches(Animal animal) {
		super(animal);
		fly();
	}

    @Override
    public void fly() {
        String className = this.getClass().getSimpleName();
        super.setFly("Fly like a " + className);
    }

}
