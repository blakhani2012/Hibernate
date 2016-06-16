package com.spy.query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class Deleteuser 
{

	
	
	public static void main(String[] args) 
	{
		
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	Session session=sf.openSession();
	
	session.beginTransaction();
	
	//fetching user 10 data
	Userdata user=(Userdata)session.get(Userdata.class, 10);
   
	//deleting user 10
	
	session.delete(user);
    session.getTransaction().commit();
    
    
	session.close();

	
	}	
	
}
