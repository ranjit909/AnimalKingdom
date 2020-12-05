package com.animal.AnimalKingdom;

public enum Penstype {
	Bird("Bird"),Mammal("Mammal"),Reptile("Reptile");

	Penstype(final String value) 
	{
    	this.value = value;
	}

	private final String value;

	public String getValue() {
		return value;
	}
	
	
}
