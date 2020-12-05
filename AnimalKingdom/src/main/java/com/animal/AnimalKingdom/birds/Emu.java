package com.animal.AnimalKingdom.birds;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IBird;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "emu")
@DiscriminatorValue("Emu")
public class Emu extends Animal  implements IBird  {
	
	public Emu() {
		super();
	}
	
    public Emu(Animal animal) {
		super(animal);
		fly();
	}

    @Override
    public void fly() {
        String className = this.getClass().getSimpleName();
        super.setFly("Fly like a " + className);
    }

}
