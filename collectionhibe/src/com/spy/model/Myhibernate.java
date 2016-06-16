package com.spy.model;

import java.util.Collection;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.collection.Address;

import org.hibernate.Session;


public class Myhibernate 
{
 public static void main(String[] args) 
 {
try
{
	
	
   User_info user=new User_info();
   
   user.setUserid(1);
   user.setUsername("bhavksdxnesh");
	
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
   
  // user.getListofaddress();
       
   Set a=user.getListofaddress();
   a.add(home);
   
   Set b=user.getListofaddress();
   a.add(city);


  SessionFactory s = new Configuration().configure().buildSessionFactory();

  org.hibernate.Session session=s.openSession();
  
  session.beginTransaction();
  session.save(user);
  
 // session.save(ref1);
  session.getTransaction().commit();
  
}


catch(HibernateException e)
{
	
	e.printStackTrace();
}
   
 }	
	

}
