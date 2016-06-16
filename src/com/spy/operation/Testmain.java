package com.spy.operation;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testmain 
{

	
	public static void main(String[] args) 
	{
	
		for(int i=1;i<=10;i++)
		{
			
		Userdata user=new Userdata();
		user.setUser("user "+i); 
		
		
		}
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		for(int i=1;i<=10;i++)
		{
			
		Userdata user=new Userdata();
		user.setUser("user "+i); 
		
		session.save(user);
		
		}
		session.getTransaction().commit();
		
		
	//Userdata user=(Userdata)session.get(Userdata.class,5);
	
	
//	System.out.println(user.getUser());
		
	//	session.close();
			
	}
}
