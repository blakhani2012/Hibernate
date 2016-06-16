package com.spy.inherit;

import javax.persistence.Entity;

@Entity
public class Twowhiler extends Vehicle
{
	String handle;

	public String getHandle() 
	{
		return handle;
	}

	public void setHandle(String handle) 
	{
		this.handle = handle;
	}
	

}
