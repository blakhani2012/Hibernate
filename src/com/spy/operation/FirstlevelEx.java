package com.spy.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstlevelEx 
{
	public static void main(String[] args) {
		
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		    
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		
		//getting user
	    Userdata user=(Userdata)session.get(Userdata.class,5);
		
	    
	   
		session.getTransaction().commit();
	    session.close();
		
		
	    
        Session session2=sessionfactory.openSession();
		
		session2.beginTransaction();
		
		
		Userdata user2=(Userdata)session2.get(Userdata.class,5);
	    
		session2.getTransaction().commit();
		session2.close();
	    
	    
		}
		
}
