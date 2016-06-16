package com.spy.bird;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test 

{

	public static void main(String[] args)
	{
		
		Bird b=new Bird();
	    b.setBirdname("parrot");
	    b.setId(1);
		Flying f=new Flying();
		f.setName("duck");
		f.setType("flying");
		
		Nonflying n=new Nonflying();
		n.setName("yxx");
		n.setType("non flying");
		
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		session.save(b);
		session.save(f);
		session.save(n);
		
		session.getTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
