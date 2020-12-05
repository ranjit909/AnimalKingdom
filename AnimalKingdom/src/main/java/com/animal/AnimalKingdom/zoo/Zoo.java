package com.animal.AnimalKingdom.zoo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name = "zoo")
public class Zoo {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "zooid")
    protected Long  zooId;
	
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy="zoo")
	private List<Pens> pens;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Long getZooId() {
		return zooId;
	}

	public void setZooId(Long zooId) {
		this.zooId = zooId;
	}

	public List<Pens> getPens() {
		return pens;
	}

	public void setPens(List<Pens> pens) {
		this.pens = pens;
	}
    
}