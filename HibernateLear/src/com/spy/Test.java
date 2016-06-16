package com.spy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test 
{

	public static void main(String[] args) 
	{
	
		/*for(int i=1;i<=10;i++)
		{
		UserInformation user=new UserInformation();
		user.setName("user "+i);
		}*/
		
       SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		for(int i=1;i<=10;i++)
		{
			
		UserInformation user=new UserInformation();
		user.setName("user "+i);
		session.save(user);
		}
		
		
		
		
		
		session.getTransaction().commit();
		
		session.close();
		
		
		
		
		
	
	
	
	
	
	}
}
