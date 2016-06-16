package com.spy.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaApi 
{

	public static void main(String[] args) 
	{
	
		
	
		 SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			
		 
		                     
		    Criteria criteria= session.createCriteria(Userdata.class);
			
		    criteria.add(Restrictions.eq("user", "user 6"));
		    
		    
		    
		    System.out.println("*************************************");
		    
 
		    //criteria2.add(Restrictions.ge("id",6));
		    
		    
		    
		    
		
		  
		    List<Userdata> user=criteria.list();
		    
		    session.getTransaction().commit();
			
			session.close();
			
			
		for (Userdata userdata : user) 
		{
		
			System.out.println(userdata.getUser());
		}		
	}

	
}
