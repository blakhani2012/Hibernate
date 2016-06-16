package com.spy.hibernateproj;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="student_info")
public class Userdetails

{
   @Id @GeneratedValue (strategy=GenerationType.AUTO)
   private int userid;
   
   private String username;
   
   
   
   @Embedded
   @AttributeOverrides({
   @AttributeOverride(name="street",column=@Column(name="home_strret")),
   @AttributeOverride(name="city",column=@Column(name="home_city_stret")),
   @AttributeOverride(name="state",column=@Column(name="home_state_name")),
   @AttributeOverride(name="pincode",column=@Column(name="home_pin_no")),
                      
   })
    private Address homeaddress;
   
    @Embedded
    private Address officeaddress;
   
   
   
   public Address getHomeaddress() {
	return homeaddress;
}
public void setHomeaddress(Address homeaddress) {
	this.homeaddress = homeaddress;
}
public Address getOfficeaddress() {
	return officeaddress;
}
public void setOfficeaddress(Address officeaddress) {
	this.officeaddress = officeaddress;
}


	public Address getAddress() {
	return homeaddress;
}
public void setAddress(Address address) {
	this.homeaddress = address;
}
	public int getUserid() 
	{
		return userid;
	}
	public void setUserid(int userid) 
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}	
}
