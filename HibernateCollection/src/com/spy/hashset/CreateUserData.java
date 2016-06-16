package com.spy.hashset;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateUserData 
{
	
	public static void main(String[] args) {
		
	
	
	
	
	User_info_data user=new User_info_data();
	
	user.setUserid("vivek007");
	user.setName("Vivek Patel");
	
	
	
	
	Address home=new Address();
	home.setSociety("rupani divdi");
	home.setCity("bhavnagar");
	home.setPincode(1234);
	
	
	//gettting list of address of Set collection
	
	Address office=new Address();
	office.setSociety("pune city");
	office.setCity("pune");
	office.setPincode(1212);
	
	
	//adding object into collection
	
	
	
	
	
	user.getListoAddress().add(home);
	user.getListoAddress().add(office);
	
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
    Session session=sf.openSession();
	
    session.beginTransaction();
    session.save(user);
	
    session.getTransaction().commit();
	
	session.close();

	}	
}
