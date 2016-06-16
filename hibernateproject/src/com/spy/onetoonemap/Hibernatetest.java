package com.spy.onetoonemap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatetest 
{

	public static void main(String[] args) 
	
	{
	
		Userdetailsu user=new Userdetailsu();
		user.setUserid(1);
		user.setName("bhavesh");
		
		Vehiclev vehicle=new Vehiclev();
		vehicle.setVehiclename("car");
	
		
		user.getVehicle();
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		
		session.getTransaction().commit();
		
		
		session.close();
		
	}
}
