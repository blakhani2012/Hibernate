package com.spy.hibernate.AttributeOverride;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address 
{

	@Column(name="Office_street")
	String streetname;
	
	@Column(name="Office_society")
	String society;
	
	@Column(name="Office_city")
	String city;
	
	@Column(name="Office_pincode")
	int pincode;

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
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
