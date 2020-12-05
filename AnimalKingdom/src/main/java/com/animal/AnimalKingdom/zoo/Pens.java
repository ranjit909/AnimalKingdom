package com.animal.AnimalKingdom.zoo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pens")
public class Pens 
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pen_id")
    protected Long  penId;
	
	@Column(name = "pentype")
	private String penType;
	
    @ManyToOne
	@JoinColumn(name="zooid")
	private Zoo zoo;
    
    @Column(name = "penname")
    private String penName;
    
	public Long getPenId() {
		return penId;
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

	public void setPenId(Long penId) {
		this.penId = penId;
	}

	public Zoo getZoo() {
		return zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
	
}
