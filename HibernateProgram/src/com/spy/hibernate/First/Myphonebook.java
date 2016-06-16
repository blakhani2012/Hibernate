package com.spy.hibernate.First;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contactbook")
public class Myphonebook 
{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	
    int id;
	
	String name;
	String mobilenumber;
	

	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
	
}
