package com.spy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import com.spy.collection.Address;

@Entity 
@Table (name="users_info")
public class User_info

{
   @Id @GeneratedValue (strategy=GenerationType.AUTO)
   
	private int userid;
   private String username;
   
    @ElementCollection
    @JoinTable(name="user_address",joinColumns=@JoinColumn(name="user_id"))
  
    Set<Address> listofaddress=new HashSet<Address>();
    

	public Set<Address> getListofaddress() {
		return listofaddress;
	}
	public void setListofaddress(Set<Address> listofaddress) {
		this.listofaddress = listofaddress;
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
