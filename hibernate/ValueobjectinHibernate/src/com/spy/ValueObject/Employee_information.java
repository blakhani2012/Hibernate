package com.spy.ValueObject;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;


@Entity
public class Employee_information 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	
	Address address;
	
	
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	Date joindate;

	
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	
	public Date getJoindate() 
	{
		return joindate;
	}
	
	public void setJoindate(Date joindate) 
	{
		this.joindate = joindate;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
}
