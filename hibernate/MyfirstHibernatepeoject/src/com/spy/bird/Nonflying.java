package com.spy.bird;

import javax.persistence.Entity;

@Entity
public class Nonflying 

{
	String id;
	
	
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
String type;


	
	
}
