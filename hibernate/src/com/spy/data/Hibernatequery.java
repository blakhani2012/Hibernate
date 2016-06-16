package com.spy.data;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

public class Hibernatequery 
{

	public static void main(String[] args) 
	{
	
	    /*Employee12 emp12=new Employee12();
		
		emp12.setId(1);
		emp12.setName("bhavesh");
		
		*/
		
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session= sessionfactory.openSession();
		session.beginTransaction();
	    
		Query query=session.createQuery("from Employee12");
		
		java.util.List<Employee12> listofuser = query.list();
		
		session.getTransaction().commit();
		
		
		
		
		
		session.close();
		for (Employee12 employee12 : listofuser)
		{
		
			System.out.println(employee12.getName());
		}
		
		
		
		
		//System.out.println(listofuser.size());
	}
	
	
}
