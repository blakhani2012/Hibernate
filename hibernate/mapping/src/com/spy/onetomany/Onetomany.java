package com.spy.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Onetomany
{

	
	public static void main(String[] args) {
		
	
	
	User111 user=new User111();
	user.setName("bhavesh");
	user.setUserid(1);
	
	Vehicle111 v1=new Vehicle111();
	v1.setVehiclename("car");
	
	Vehicle111 v2=new Vehicle111();
	v2.setVehiclename("bike");
	
	user.getVehicles().add(v1);
	user.getVehicles().add(v2);
	
	
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.save(v1);
	session.save(v2);
	session.getTransaction().commit();
	
	session.close();
	
	
	}
	
}
