package com.spy.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.spy.hibernateproj.Address;
import com.spy.hibernateproj.Userdetails;

public class Myhibernate 
{
 public static void main(String[] args) 
 {
try
{
	
	
   Userdetails ref=new Userdetails();
   
   ref.setUserid(1);
   ref.setUsername("bhavksdxnesh");
	
   Address home=new Address();
   
   home.setStreet("9th main");
   home.setCity("bangalore");
   home.setState("karnataka");
   home.setPincode("1234");

   
   
 
   
  
	
   Address city=new Address();
   
   city.setStreet("whitefieldin");
   city.setCity("bangalore");
   city.setState("karnataka");
   city.setPincode("3334");

   
   
   
   ref.setAddress(home);
   ref.setAddress(city);
   
   
   
   
   
	
    	
	
	

	SessionFactory s = new Configuration().configure().buildSessionFactory();

  org.hibernate.Session session=s.openSession();
  
  session.beginTransaction();
  session.save(ref);
  
 // session.save(ref1);
  session.getTransaction().commit();
  
}


catch(HibernateException e)
{
	
	e.printStackTrace();
}
   
 }	
	

}
