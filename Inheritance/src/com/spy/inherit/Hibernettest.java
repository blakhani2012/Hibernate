package com.spy.inherit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernettest 
{

	public static void main(String[] args) {
		
	
	
		Vehicle vehicle=new Vehicle();
		vehicle.setId(1);
		vehicle.setName("carr");
		
		Twowhiler bike=new Twowhiler();
		bike.setName("honda");
		bike.setHandle("steering handle");
		
		
		Fourwhiler car=new Fourwhiler();
		car.setName("bmw");
		car.setSteering("steering wheel");
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		session.getTransaction().commit();
		
		session.close();
	}	
		
	}

