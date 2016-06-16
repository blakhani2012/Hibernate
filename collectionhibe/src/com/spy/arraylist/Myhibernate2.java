package com.spy.arraylist;



import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.collection.Address;

import org.hibernate.Session;


public class Myhibernate2 
{
 public static void main(String[] args) 
 {
try
{
	
	
   User_info2 user=new User_info2();
   
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
   
   
   
  Collection c1=user.getListofaddress();
  c1.add(home);
  
  Collection c2=user.getListofaddress();
  c1.add(city);
 
       
   

  SessionFactory s = new Configuration().configure().buildSessionFactory();

  org.hibernate.Session session=s.openSession();
  
  session.beginTransaction();
  session.save(user);
  
 // session.save(ref1);
  session.getTransaction().commit();
  
  //session.close();
  
  user=null;
  
  session=s.openSession();
  
  user=(User_info2) session.get(User_info2.class,22);
//  session.close();
  
 System.out.println(user.getListofaddress().size());
  
}


catch(HibernateException e)
{
	
	e.printStackTrace();
}
   
 }	
	

}
