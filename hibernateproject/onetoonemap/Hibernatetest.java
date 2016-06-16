package com.spy.onetoonemap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatetest 
{

	public static void main(String[] args) 
	
	{
	
		Userdetails1 user=new Userdetails1();
		user.setUserid("1");
		user.setName("bhavesh");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehiclename("car");
		vehicle.setVehicleid("1");
		
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
