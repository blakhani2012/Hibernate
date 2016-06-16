package com.spy.hashset;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address
{

	String society;
	String city;
	int pincode;
	
	
	public String getSociety() 
	{
		return society;
	}
	
	public void setSociety(String society) 
	{
		this.society = society;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public int getPincode() 
	{
		return pincode;
	}
	
	public void setPincode(int pincode) 
	{
		this.pincode = pincode;
	}
	
	
	
	
	
	
	
	
	
	
}
