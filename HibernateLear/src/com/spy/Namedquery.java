package com.spy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Namedquery 
{

	public static void main(String[] args) {
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	Session session= sessionfactory.openSession();
	session.beginTransaction();
	
    
	//Query query=session.createQuery("from UserInformation where id>5");
	
	Query query= session.getNamedQuery("uinfo");
	
	java.util.List<UserInformation> listofuser = query.list();
	
	session.getTransaction().commit();
	
	session.close();
	
	
	
	for (UserInformation userInformation : listofuser) 
	{
		
		System.out.println(userInformation.getName());
		
	}	
 }
	
}
