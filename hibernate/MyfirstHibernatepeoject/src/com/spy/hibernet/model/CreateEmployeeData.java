package com.spy.hibernet.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.hibernate.Employee;

public class CreateEmployeeData 
{

	public static void main(String[] args)
	{
		Employee e=new Employee();
		e.setId(1);
	    e.setName("bhavesh");
		e.setAddress("jpnagar");
		
		
		
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
	
	
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(e);
	session.getTransaction().commit();
	
	session.close();
	
	
		
		
	}
	
	
}
