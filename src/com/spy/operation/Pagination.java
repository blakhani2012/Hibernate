package com.spy.operation;

import java.awt.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Pagination 
{
	public static void main(String[] args) 
	{
		
        SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from Userdata");
		
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		
		java.util.List<Userdata> users=query.list();
		
		session.getTransaction().commit();
		
		session.close();
		
		for (Userdata userdata : users) 
		{
			System.out.println(userdata.getUser());
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
