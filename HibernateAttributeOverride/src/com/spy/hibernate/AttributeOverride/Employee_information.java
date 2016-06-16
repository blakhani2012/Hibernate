package com.spy.hibernate.AttributeOverride;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;


@Entity
@Table (name="emp_data")
public class Employee_information 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	@Embedded
	@AttributeOverrides(
			{
				@AttributeOverride(name="streetname",column=@Column(name="homestreet")),
				
				@AttributeOverride(name="society",column=@Column(name="HomeSociety")),
				
				@AttributeOverride(name="city",column=@Column(name="homecity")),
				
				@AttributeOverride(name="pincode",column=@Column(name="homepincode")),	
	     		}
			)
	
	Address homeaddress;
	
	
	
	@Embedded
	Address officeadress;

	public Address getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}
	public Address getOfficeadress() {
		return officeadress;
	}
	public void setOfficeadress(Address officeadress) {
		this.officeadress = officeadress;
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
