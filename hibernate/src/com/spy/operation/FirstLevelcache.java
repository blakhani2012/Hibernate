package com.spy.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelcache 
{

	public static void main(String[] args) {
		
	
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	Session session=sessionfactory.openSession();
	
	session.beginTransaction();
	
	
	
	//getting user
    Userdata user=(Userdata)session.get(Userdata.class,5);
	
    
    //getting same user again it is already avaible in first level cache
    
    Userdata user2=(Userdata)session.get(Userdata.class,5);
	
	
    
    session.close();
	
	
	
	}
	
	
}
