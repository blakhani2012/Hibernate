package com.spy.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatetest 
{

	public static void main(String[] args) 
	
	{
	
		Userdetails1 user=new Userdetails1();
		user.setName("bhavesh");
		user.setUserid(1);
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehiclename("car");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehiclename("bike");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		
		
		session.close();
		
	}
}
