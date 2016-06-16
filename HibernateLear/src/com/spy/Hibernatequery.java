package com.spy;



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
		
	    int a=7;
		//Query query=session.createQuery("from UserInformation where id>5");
		
		Query query=session.createQuery("from UserInformation where id>?");

		query.setInteger(0,a);
		
		java.util.List<UserInformation> listofuser = query.list();
		
		session.getTransaction().commit();
		
		
		
		
		
		session.close();
		for (UserInformation user : listofuser)
		{
		
			System.out.println(user.getName());
		}
		
		
		
		
		//System.out.println(listofuser.size());
	}
	
	
}
