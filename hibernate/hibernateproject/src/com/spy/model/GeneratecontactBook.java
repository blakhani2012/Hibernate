package com.spy.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.hibernateproj.Mycontact;

public class GeneratecontactBook 
{
	
	public static void main(String[] args) 
	
	{
		
		Mycontact contact=new Mycontact();
		
		contact.setName("bhavesh");
		contact.setMob(885576878);
		
		
		try {
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionfactory.openSession();
			
			session.beginTransaction();
			session.save(contact);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
