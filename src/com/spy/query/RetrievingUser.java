package com.spy.query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class RetrievingUser
{

	
	public static void main(String[] args) 
	{
		
 
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	Session session=sf.openSession();
	
	session.beginTransaction();
	
	
	Userdata user=(Userdata)session.get(Userdata.class, 5);

	
/*	
 * System.out.println(user.getUser());  
 * 
 * */	
	
	session.close();
	
	
	System.out.println(user.getUser());
	
	
	
	
	
	}
}
