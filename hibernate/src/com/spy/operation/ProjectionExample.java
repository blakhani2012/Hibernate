package com.spy.operation;

import java.util.List;

import javax.persistence.OrderBy;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProjectionExample 
{

	public static void main(String[] args) 
	{
	
		   SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
			
					Session session=sessionfactory.openSession();
					session.beginTransaction();
					
					
					
					Userdata user=new Userdata();
					user.setId(6);
					user.setUser("user 6");
					
					//creating Example and passing user object as per requirement
			         Example example11=Example.create(user);
					
					
					
					
					
				 
				 
				/* Criteria criteria= session.createCriteria(Userdata.class)
						 
						           .addOrder(Order.desc("user"));
						        
				List<Userdata> user=criteria.list();
				
				System.out.println("**********************");*/
				
				Criteria criteria2= session.createCriteria(Userdata.class)
						            .add(example11);
						 
				          
				        
		        List<Userdata> user2=criteria2.list();
				    
				session.getTransaction().commit();
					
				session.close();
					
					
				/*for (Userdata userdata : user) 
				{
				
					System.out.println(userdata.getUser());
				}	*/
		
		
	//	System.out.println("*********************");
				
		for (Userdata u1 : user2) 
		{
		
			System.out.println(u1.getUser());
		}	
	}
}
