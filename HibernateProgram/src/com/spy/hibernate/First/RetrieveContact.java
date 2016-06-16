package com.spy.hibernate.First;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveContact 
{

	public static void main(String[] args) 
	{

		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
	    Myphonebook contact2= (Myphonebook)session.get(Myphonebook.class, 1);
		
	    System.out.println("Conatct name: "+contact2.getName());
		
	    System.out.println(" mobile Number: "+contact2.getMobilenumber());

		
	}
	
}
