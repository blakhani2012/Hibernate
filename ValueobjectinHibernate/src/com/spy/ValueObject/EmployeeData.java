package com.spy.ValueObject;

import java.util.Date;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData 
{

	public static void main(String[] args) 
	{
	
		Employee_information info=new Employee_information();
		
		info.setName("bhavesh");
		
		
		
		
		
		
		Address addr=new Address();
		addr.city="surat";
		addr.Streetname="krishna Avenue";
		addr.pincode=1234;
		addr.Society="orchid plaza";
		
		
		info.setAddress(addr);
		
         
		info.setJoindate(new Date());
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	    Session session=sf.openSession();
		
	    session.beginTransaction();
	    session.save(info);
		
	    session.getTransaction().commit();
		
		
	}

}
