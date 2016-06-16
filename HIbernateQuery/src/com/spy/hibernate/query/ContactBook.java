package com.spy.hibernate.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.hibernate.First.Myphonebook;

public class ContactBook 
{

	
	
	public static void main(String[] args) 
	{
		
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	
	Session session=factory.openSession();
	
	Query query=session.createQuery("from Myphonebook where id > ?");
     
	query.setInteger(0,2) ;
	
	List<Myphonebook> c=query.list();
	
	for (Myphonebook myphonebook : c)
	{
	
		System.out.println("name is "+myphonebook.getName());
		System.out.println("mobile number "+myphonebook.getMobilenumber());
		
	}
	 
	 
	 
	}
	
	
}
