package com.animal.AnimalKingdom.general;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.animal.AnimalKingdom.zoo.Pens;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="animaltype",
    discriminatorType=DiscriminatorType.STRING
)
//@DiscriminatorValue("Animal")
public  class Animal {

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long  ID;
    
    protected String name;
    
    @ManyToOne
    @JoinColumn(name="pen_id")
	private Pens pen;
    
    @Column(name = "crawl")
    private String crawl;
    
    @Column(name = "fly")
    private String fly;
    
    @Column(name = "suckle")
    private String suckle;
    
    @Transient
    private String penType;
    
    @Transient
    private String penName;
    
    public Animal(Animal animal) {
		this.name=animal.name;
		this.pen=animal.getPen();
	}

	public Animal() {
	}

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Pens getPen() {
		return pen;
	}

	public void setPen(Pens pen) {
		this.pen = pen;
	}

	public String getPenType() {
		return penType;
	}

	public void setPenType(String penType) {
		this.penType = penType;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getCrawl() {
		return crawl;
	}

	public void setCrawl(String crawl) {
		this.crawl = crawl;
	}

	public String getFly() {
		return fly;
	}

	public void setFly(String fly) {
		this.fly = fly;
	}

	public String getSuckle() {
		return suckle;
	}

	public void setSuckle(String suckle) {
		this.suckle = suckle;
	}

}
