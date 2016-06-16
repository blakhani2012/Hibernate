package com.spy.operation;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity

@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)


@NamedQuery(name="Userdata.byid",query=" from Userdata where id > ? ")

@NamedNativeQuery(name = "Userdata.byname", query = "Select *from Userdata where id=? and user=?",resultClass=Userdata.class )
public class Userdata 
{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
