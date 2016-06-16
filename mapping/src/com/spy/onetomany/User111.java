package com.spy.onetomany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User111 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int userid;
	
	
	String name;
	
	@OneToMany
	
	Collection<Vehicle111> vehicles=new ArrayList<>();


	


	

	public int getUserid() 
	{
		return userid;
	}


	public Collection<Vehicle111> getVehicles() {
		return vehicles;
	}


	public void setVehicles(Collection<Vehicle111> vehicles) {
		this.vehicles = vehicles;
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


	
		
}
