package com.spy.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle11 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int vehicleid;
	String vehiclename;
	
	public int getVehicleid()
	{
		return vehicleid;
	}
	
	public void setVehicleid(int vehicleid) 
	{
		this.vehicleid = vehicleid;
	}
	
	public String getVehiclename()
	{
		return vehiclename;
	}
	
	public void setVehiclename(String vehiclename) 
	{
		this.vehiclename = vehiclename;
	}
	
}
