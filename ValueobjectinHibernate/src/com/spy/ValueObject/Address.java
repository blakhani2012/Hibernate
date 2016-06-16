package com.spy.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address 
{

	@Column(name="Office_street")
	String Streetname;
	
	@Column(name="Office_society")
	String Society;
	
	@Column(name="Office_city")
	String city;
	
	@Column(name="Office_pincode")
	int pincode;
	
	
	public String getStreetname() {
		return Streetname;
	}
	public void setStreetname(String streetname) {
		Streetname = streetname;
	}
	public String getSociety() {
		return Society;
	}
	public void setSociety(String society) {
		Society = society;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	
}
