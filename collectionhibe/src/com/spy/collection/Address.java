package com.spy.collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
   public String street;
   public String city;
   public String state;
   public String pincode;
   
  
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
}
