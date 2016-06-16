package com.spy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.hibernateproj.Studentdata;

public class Retrievedata 
{

	public static void main(String[] args) 
	{
	
		
		Studentdata ref1=new Studentdata();
		//user=null;
	    System.out.println(ref1.getId());
	    System.err.println(ref1.getUsername());
	    System.out.println(ref1.getDescription());
		
	SessionFactory sessionf=new Configuration().configure().buildSessionFactory();
	
	System.out.println(ref1.getId());
  	Session session=sessionf.openSession();
	session.beginTransaction();
    session.save(ref1);
	session.close();
		
		
		
		
	
	  ref1=null;
		
	  ref1=(Studentdata)session.get(Studentdata.class,1);
	   
	 // System.out.println("username is :"+ref1.getId());
	 // System.out.println("id is :"+ref1.getId());
		
	}
}
