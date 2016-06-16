package com.spy.model;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.hibernateproj.Studentdata;

public class CreateStudentdata 
{

	
	public static void main(String[] args) 

	{
		
		Studentdata ref1=new Studentdata();
		
		ref1.setUsername("bllakhani2012");
		ref1.setId(1);
		ref1.setJoindate(new Date());
		ref1.setDescription("hii this is bhavesh lakhani");
		
		
		try {
			SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
			
			
			Session session=sessionfactory.openSession();
			
			session.beginTransaction();
			session.save(ref1);
			
			session.getTransaction().commit();
			
			session.close();
			
			
			Session session1=sessionfactory.openSession();
			session1.beginTransaction();
			
		   ref1=(Studentdata)session1.get(Studentdata.class,1);
			
		   System.out.println(ref1.getUsername());
			
			
		} 
		
		catch (HibernateException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
