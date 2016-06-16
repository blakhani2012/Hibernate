package com.spy.hibernate.AttributeOverride;

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
		
	
		Address home=new Address();
		home.city="surat";
		home.streetname="krishna Avenue";
		home.pincode=1234;
		home.society="orchid plaza";
		
		
		info.setHomeaddress(home);
		
		
		
		Address office=new Address();
		office.city="bangalore";
		office.streetname="jpnager";
		office.pincode=12345;
		office.society="xyz";
		
		info.setOfficeadress(office);
		
         
		info.setJoindate(new Date());
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	    Session session=sf.openSession();
		
	    session.beginTransaction();
	    session.save(info);
		
	    session.getTransaction().commit();
		
		session.close();
		
	}

}
