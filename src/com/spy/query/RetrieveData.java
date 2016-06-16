package com.spy.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class RetrieveData 
{

	public static void main(String[] args) 
	{
	
		//Userdata user=new Userdata();
		
		
		//SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();

		
		Session session=sf.openSession();
		
		session.beginTransaction();
		
		 
		Query query=session.createQuery("from Userdata where id>7");
		
	
		List<Userdata> user1=query.list();
		
		
		for (Userdata userdata : user1)
		{
		
			System.out.println(userdata.getUser());
			
		}
		
	}

}
