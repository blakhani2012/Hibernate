package com.spy.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.spy.collection.Address;

@Entity 
@Table (name="user_info2")
public class User_info2

{
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   
	private int userid;
    private String username;
   
    @ElementCollection(fetch=FetchType.EAGER)
    @JoinTable(name="user_address2",joinColumns=@JoinColumn(name="user_id"))
    
    @GenericGenerator(name="hilo-gen",strategy="hilo")
    @CollectionId(columns ={@Column(name="address_index") }, generator = "hilo-gen", type = @Type(type="long"))
    
    
    Collection<Address> listofaddress=new ArrayList<Address>();
    

	
	
	
	public Collection<Address> getListofaddress() {
		return listofaddress;
	}
	public void setListofaddress(Collection<Address> listofaddress) {
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
