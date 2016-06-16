package com.spy.hashset;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class User_info_data 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String userid;
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	String name;
	
	
	@ElementCollection
	
	@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id")) 
	
	
	Set<Address> listoAddress=new HashSet<>();


	public int getId() {
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


	public Set<Address> getListoAddress() {
		return listoAddress;
	}


	public void setListoAddress(Set<Address> listoAddress) {
		this.listoAddress = listoAddress;
	}


	
	
    
	
}
