package com.spy.onetoone;

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
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehiclename("car");
		
		user.setV(vehicle);
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
