package com.spy.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testhibernate 
{

	public static void main(String[] args) 
	{
	
		
		Employee12 emp=new Employee12();
		emp.setId(1);
		emp.setName("vivek");
		
	
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		session.close();
		
		
	  emp=null;
	  
	  session=sessionfactory.openSession();
		
	  emp=(Employee12)session.get(Employee12.class,1);
		
	  System.out.println(emp.name);
		
		
		
	}
	
	
	
	
	
}
