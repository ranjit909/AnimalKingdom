package com.animal.AnimalKingdom.birds;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IBird;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "eagles")
@DiscriminatorValue("Eagles")
public class Eagles extends Animal  implements IBird  {
	public Eagles() {
		super();
	}
	public Eagles(Animal animal) {
		super(animal);
		fly();
	}

    @Override
    public void fly() {
        String className = this.getClass().getSimpleName();
        super.setFly("Fly like a " + className);
    }

}
