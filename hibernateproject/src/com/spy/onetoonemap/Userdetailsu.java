package com.spy.onetoonemap;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Userdetailsu 
{
    @Id 
	int userid;
	String name;
	
    @OneToMany(mappedBy="user")
    
    
	Collection<Vehiclev> vehicle=new ArrayList<Vehiclev>();
    
	
	
	
	public Collection<Vehiclev> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehiclev> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
