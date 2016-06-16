package com.spy.operation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Namedquery 
{
  
	public static void main(String[] args) {
		
	
	
	 SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
	 //String userid="5";
	 
	/* Query query=session.getNamedQuery("Userdata.byid");
	 
	 query.setInteger(0,Integer.parseInt(userid));
		
	  List<Userdata> users=query.list();*/
	  
	  
	  
	  
	  
	  
	  Query query2=session.getNamedQuery("Userdata.byname");
	  
	  query2.setInteger(0,1);
	  query2.setString(1,"user 1");
	  
	  
	List<Userdata> u1=  query2.list();
	
	
	  
	  
	  
	  session.getTransaction().commit();
		
		session.close();
		
		
	/*	
		for (Userdata userdata : users)
		{
		
			System.out.println(userdata.getUser());
		}
	
		
		System.out.println("****************");*/
		
		for(Userdata u:u1)
		{
			System.out.println(u.getUser());
		}
}
}
