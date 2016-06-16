package com.spy.cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class Firstlevel 
{

	
	public static void main(String[] args)
	{
	
	//	Userdata user=new Userdata();
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		
		
		Userdata user3=(Userdata)session.get(Userdata.class, 3);
		//session.update("updated user",user1);
		session.update("again update", user3);
		/*
		 * 
		 * 
		 * 
		 * some line of code................
		 * 
		 * 
		 * 
		 */
		
		Userdata user2=(Userdata)session.get(Userdata.class, 3);
		
		session.getTransaction().commit();
		session.close();
		
		/*
		 * after closing session opening new Session
		 * 
		 */
		
		/*
        session=sessionfactory.openSession();
		
		session.beginTransaction();
		
		
        //here user object already available in first level cache but it fier new query
		//thats why we require second level cache..
		
		//after enableing second level cache hibernate fier only one query...
		
		Userdata user1=(Userdata)session.get(Userdata.class, 3);
		*/
		
	}
	
	
	
	
	
	
	
}
