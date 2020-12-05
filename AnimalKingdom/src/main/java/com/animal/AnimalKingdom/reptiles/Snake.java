package com.animal.AnimalKingdom.reptiles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.animal.AnimalKingdom.Interfaces.IReptile;
import com.animal.AnimalKingdom.general.Animal;

@Entity(name = "snake")
@DiscriminatorValue("Snake")
public class Snake extends Animal  implements IReptile  {

	public Snake() {
		super();
	}

	public Snake(Animal animal) {
		super(animal);
		crawl();
	}

	@Override
	public void crawl() {
		String className = this.getClass().getSimpleName();
		super.setCrawl("Crawl like a " + className);
	}
	
}
