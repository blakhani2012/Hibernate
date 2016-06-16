package com.spy.cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class SecondlevelCache 
{

	public static void main(String[] args)
	{
	
		//Userdata user=new Userdata();
		
		
				SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
				
				Session session=sessionfactory.openSession();
				
				session.beginTransaction();
				
				
				
				Userdata user1=(Userdata)session.get(Userdata.class, 1);
				session.update("updated user",user1);
				
				/*
				 * 
				 * 
				 * 
				 * some line of code................
				 * 
				 * 
				 * 
				 */
				
				Userdata user2=(Userdata)session.get(Userdata.class, 1);
				
				session.getTransaction().commit();
				session.close();
				
				/*
				 * after closing session opening new Session
				 * 
				 */
				
				
		        session=sessionfactory.openSession();
				
				session.beginTransaction();
				
				
		        //here user object already available in first level cache but it fier new query
				//thats why we require second level cache..
				
				//after enableing second level cache hibernate fier only one query...
				
				Userdata user3=(Userdata)session.get(Userdata.class, 1);
		
		
				
				

	}

}
