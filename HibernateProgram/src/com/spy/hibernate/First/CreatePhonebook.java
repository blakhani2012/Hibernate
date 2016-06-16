package com.spy.hibernate.First;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePhonebook 
{

	
	public static void main(String[] args) 
	{
	
		Myphonebook contact=new Myphonebook();
		
		contact.setMobilenumber("9409081223");
		contact.setName("abhilash");
		
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	    Session session=sf.openSession();
		
	    session.beginTransaction();
	    
	    session.save(contact);
		
	    session.getTransaction().commit();
		
        		
	    session.close();
		
			
	}
	
}
