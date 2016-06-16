package com.spy.inherit;

import javax.persistence.Entity;

@Entity
public class Fourwhiler extends Vehicle
{
	String steering;

	
	public String getSteering() 
	{
		return steering;
	}

	public void setSteering(String steering) 
	{
		this.steering = steering;
	}

}
