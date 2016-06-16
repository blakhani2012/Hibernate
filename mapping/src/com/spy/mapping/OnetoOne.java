package com.spy.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OnetoOne 
{

	
	public static void main(String[] args) {
		
	
	
	User11 user=new User11();
	user.setName("bhavesh");
	user.setUserid(1);
	
	Vehicle11 vehicle=new Vehicle11();
	vehicle.setVehiclename("car");
	
	user.setVehicle(vehicle);
	
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.save(vehicle);
	
	session.getTransaction().commit();
	
	session.close();
	
	
	}
	
}
