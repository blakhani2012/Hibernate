package com.spy.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Order;

public class Example 
{

	public static void main(String[] args)
	{
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		
		Userdata example=new Userdata();
		example.setId(6);
		example.setUser("user%");
		
		
		org.hibernate.criterion.Example e=org.hibernate.criterion.Example.create(example);
		
		
		Criteria criteria=session.createCriteria(Userdata.class).add(e);
		
		
	 
	
	          
	        
    List<Userdata> user2=criteria.list();
	    
	session.getTransaction().commit();
		
	session.close();
		
		
	

System.out.println("*********************");
for (Userdata u1 : user2) 
{

System.out.println(u1.getUser());


       }	
	}	
}
