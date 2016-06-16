package com.spy.bird;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bird 
{
    public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	@Id @GeneratedValue
	int id;
	String birdname;
	public String getBirdname() 
	{
		return birdname;
	}
	public void setBirdname(String birdname) {
		this.birdname = birdname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	String color;
	
}
