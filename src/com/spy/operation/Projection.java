package com.spy.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Projection 
{

	
	public static void main(String[] args)
	{
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
	 
	                     
	    Criteria criteria= session.createCriteria(Userdata.class)
	    		.setProjection(Projections.max("id"));
	    		          
	    
	    
	    
	   /* Criteria criteria2= session.createCriteria(Userdata.class)
	    		.setProjection(Projections.count("user"));
*/
	    
	  
	    List user=criteria.list();
	    
	    session.getTransaction().commit();
		
		session.close();
		
		
	for (Object userdata : user) 
	{
	
		System.out.println(userdata.toString());
	}		
	
  }
		
			
}
	
	
	
