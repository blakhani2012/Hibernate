package com.spy.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User11 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int userid;
	
	
	String name;
	
	@OneToOne
	Vehicle11 vehicle;


	public int getUserid() 
	{
		return userid;
	}


	public void setUserid(int userid) 
	{
		this.userid = userid;
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public Vehicle11 getVehicle() 
	{
		return vehicle;
	}


	public void setVehicle(Vehicle11 vehicle) 
	{
		this.vehicle = vehicle;
	}
		
}
