package com.spy.onetoonemap;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehiclev 
{
    @Id @GeneratedValue
	int vehicleid;
	String vehiclename;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Userdetailsu user;
	
	
	public Userdetailsu getUser() {
		return user;
	}
	public void setUser(Userdetailsu user) {
		this.user = user;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	
	
}
