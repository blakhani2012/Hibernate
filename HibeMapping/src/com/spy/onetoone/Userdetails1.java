package com.spy.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Userdetails1 
{
    @Id @GeneratedValue
	int userid;
	String name;
	
    @OneToOne
	Vehicle v;
	
	public Vehicle getV() {
		return v;
	}
	public void setV(Vehicle v) {
		this.v = v;
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
