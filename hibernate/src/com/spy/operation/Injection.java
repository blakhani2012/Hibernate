package com.spy.operation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Injection

{

	public static void main(String[] args) 
	{
	
		  SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			
		 String userid="5";
		 
		 Query query=session.createQuery("from Userdata where id > ?");
		 
		 query.setInteger(0,Integer.parseInt(userid));
			
		  List<Userdata> users=query.list();
		
			session.getTransaction().commit();
			
			session.close();
			
			
			
			for (Userdata userdata : users)
			{
			
				System.out.println(userdata.getUser());
			}
		
	}
	
	/*
	 * 
	 */
	
	
}
