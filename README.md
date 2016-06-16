# Hibernate
Saving Object in Database Using Hibernate


Hibernate.cfg.xml

<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Database connection settings -->

  <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
  <property name="connection.url">jdbc:mysql://localhost:3306/test</property>
  <property name="connection.username">root</property>
  <property name="connection.password">root</property>

  <!-- JDBC connection pool (use the built-in) -->
  <property name="connection.pool_size">10</property>

  <!-- Drop and re-create the database schema on startup -->
  <property name="hbm2ddl.auto">create</property>

  <!-- SQL dialect -->
  <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

 <!-- Disable the second-level cache  -->

  <property> 
  
      name="cache.provider_class">org.hibernate.cache.NoCacheProvider

  </property>

 <!-- Echo all executed SQL to stdout -->
 <property name="show_sql">true</property>


 <mapping class="com.spy.hibernate.First.Myphonebook"/>
         
         
   
    </session-factory>

</hibernate-configuration>


JAVA Bean class (POJO)

Myphonebook.java

package com.spy.hibernate.First;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Myphonebook 
{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
      int id;
	
	String name;
	String mobilenumber;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
      public int getId() 
      {
		return id;
	}

	public void setId(int id)
      {
		this.id = id;
	}

	
}


Createphonebook.java

package com.spy.hibernate.First;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePhonebook 

  {


public static void main(String[] args) 
	

    {

Myphonebook contact=new Myphonebook();
contact.setMobilenumber("8866766995");
contact.setName("bhavesh");

		
SessionFactory sf=new Configuration().configure().buildSessionFactory();

Session session=sf.openSession();

session.beginTransaction();
session.save(contact);

session.getTransaction().commit();


session.close();

		
		
	}
	
}

Output:  Hibernate: insert into Myphonebook (mobilenumber, name) values (?, ?)
See in your mysql  Database using query: Select *from Myphonebook; 
 


Annotation

@Entity
This annotation used to mark class as Entity

@Entity(name=”Contactbook”)
It has only one Attribute called name.

@Table(name=”tablename”)
This annotation used to give a table name.

@Id
This annotation used to mark field as a primary key.

@Id @GeneratedValue(strategy=GenerationType.AUTO)
This annotation used to Generate Auto increment primary key.

@Transient
Hibernate Automatically create table by Seeing your member Variable of Class But if you want that Some Variable not Save in Database Then Mark those field as a Trasient.

@Temporal(TemporalType.Date)
This annotation used change Date format
Default it display time, date 
But if you want only date will display then you have to use above Annotation.

@Lob
It means large object.
When you save object in database there are some Default size.
Suppose for varchar have 255 char.
But some field like Address, description require More space so we mark those a large object using above annotation.


Retrieve Data from table using Hibernate

We have already Create table Myphonebook now in this example we are going to Retrieve Some of data of that table.
Myphonebook table

 

RetrieveData.java

package com.spy.hibernate.First;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveContact 
{

public static void main(String[] args)

 {


SessionFactory sf=newConfiguration().configure().buildSessionFactory();

Session session=sf.openSession();

session.beginTransaction();

//this will Retrive contact with index 2
Myphonebook contact2= (Myphonebook)session.get(Myphonebook.class, 2);

System.out.println("Contact name : "+contact2.getName());

System.out.println("mobile Number: "+contact2.getMobilenumber());

		
 }
	
}
Output:
Hibernate: select myphoneboo0_.id as id0_0_, myphoneboo0_.mobilenumber as mobilenu2_0_0_, myphoneboo0_.name as name0_0_ from Myphonebook myphoneboo0_ where myphoneboo0_.id=?

 Contact name :  abhilash
 mobile Number: 9409081223

Value Object
In Above Example we have some member Variable and we see that How hibernate is saved those field in database.
But now consider that we have Address and it has sub attribute street, city, pin code etc. So we need to save it as address object.

1Hibernate.cgf.xml

<?xml version='1.0' encoding='utf-8'?>


<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

<!-- Database connection settings -->
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/test</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>

<!-- JDBC connection pool (use the built-in) -->
<property name="connection.pool_size">10</property>

<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">create</property>



<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

<!-- Disable the second-level cache  -->
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

<!-- Echo all executed SQL to stdout -->
<property name="show_sql">true</property>


<mapping class="com.spy.ValueObject.Employee_information"/>






</session-factory>

</hibernate-configuration>

Address.java	

package com.spy.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Address 
{

	String Streetname;
	String Society;
	String city;
	int pincode;
	
	
	public String getStreetname() 
      {
		return Streetname;
	}

	public void setStreetname(String streetname) 
      {
		Streetname = streetname;
	}

	public String getSociety()
      {
	      return Society;
	}

	public void setSociety(String society) {
		Society = society;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city)

      {
		this.city = city;
	}

	public int getPincode() 
      {
		return pincode;
	}
	public void setPincode(int pincode)
      {
		this.pincode = pincode;
	}

	
}


Employee_information.java

package com.spy.ValueObject;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;


@Entity
public class Employee_information 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	@Embedded
	Address address;
	
	
	Date joindate;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	
	public Date getJoindate() 
	{
		return joindate;
	}
	
	public void setJoindate(Date joindate) 
	{
		this.joindate = joindate;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}


Employeedata.java

package com.spy.ValueObject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData 
{

public static void main(String[] args) 
{
	
Employee_information info=new Employee_information();

info.setName("bhavesh");

Address home=new Address();
home.city="surat";
home.Streetname="krishna Avenue";
home.pincode=1234;
home.Society="orchid plaza";


info.setAddress(home);

Address office=new Address();
office.city="bangalore";
office.Streetname="jpnager";
office.pincode=12345;
office.Society="xyz";

info.setAddress(office);


info.setJoindate(new Date());
SessionFactory sf=new Configuration().configure().buildSessionFactory();

Session session=sf.openSession();

session.beginTransaction();
session.save(info);

session.getTransaction().commit();



}


}

Output:
Hibernate: insert into Employee_information (Society, Streetname, city, pincode, joindate, name) values (?, ?, ?, ?, ?, ?)

Now see table structure in your mysql database. 
 
Attribute override and embedded object

Now if we have more than one address Exa home address, city address and we have to override default address detail like street_name to Home_street_name then we have to Use Attributeoverrides.

Hibernate.cfg.xml

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

<!-- Database connection settings -->
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/test</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>

<!-- JDBC connection pool (use the built-in) -->
<property name="connection.pool_size">10</property>

<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">create</property>



<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

<!-- Disable the second-level cache  -->
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

<!-- Echo all executed SQL to stdout -->
<property name="show_sql">true</property>


<mapping class="com.spy.hibernate.AttributeOverride.Employee_information"/>
</session-factory>

</hibernate-configuration>





Address.java

package com.spy.hibernate.AttributeOverride;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address 
{
	@Column(name="Office_street")
	String streetname;
	
	@Column(name="Office_society")
	String society;
	
	@Column(name="Office_city")
	String city;

	@Column(name="Office_pincode")
	int pincode;

	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}


Employee_information.java

package com.spy.hibernate.AttributeOverride;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;


@Entity
public class Employee_information 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	
	@Embedded
	@AttributeOverrides(
			{
			@AttributeOverride(name="streetname",column=@Column(name="homestreet")),
	@AttributeOverride(name="society",column=@Column(name="HomeSociety")),
              @AttributeOverride(name="city",column=@Column(name="homecity")),
	@AttributeOverride(name="pincode",column=@Column(name="homepincode")),	
	     }
	)
	
	Address homeaddress;
	
	
	
	@Embedded
	Address officeadress;



	public Address getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}	
	public Address getOfficeadress() {
		return officeadress;
	}
	public void setOfficeadress(Address officeadress) {
		this.officeadress = officeadress;
	}

	Date joindate

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	
	public Date getJoindate() 
	{
		return joindate;
	}
	
	public void setJoindate(Date joindate) 
	{
		this.joindate = joindate;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
}
	

EmployeeData.java

package com.spy.hibernate.AttributeOverride;

import java.util.Date;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeData 
{

	public static void main(String[] args) 
	{
	
		Employee_information info=new Employee_information();
		
		info.setName("bhavesh");
		
	
		Address home=new Address();
		home.city="surat";
		home.streetname="krishna Avenue";
		home.pincode=1234;
		home.society="orchid plaza";
		
		
		info.setHomeaddress(home);
		
		
		
		Address office=new Address();
		office.city="bangalore";
		office.streetname="jpnager";
		office.pincode=12345;
		office.society="xyz";
		
		info.setOfficeadress(office);
		
         
		info.setJoindate(new Date());
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	    Session session=sf.openSession();
		
	    session.beginTransaction();
	    session.save(info);
		
	    session.getTransaction().commit();
		
	   session.close();
	}

}

























SAVING COLLECTION OBJECT IN HIBERNATE

Hibernate.cgf.xml

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

<!-- Database connection settings -->
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/test</property>
<property name="connection.username">ro



ot</property>
<property name="connection.password">root</property>

<!-- JDBC connection pool (use the built-in) -->
<property name="connection.pool_size">10</property>

<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">create</property>



<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

<!-- Disable the second-level cache  -->
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

<!-- Echo all executed SQL to stdout -->
<property name="show_sql">true</property>



<mapping class="com.spy.hashset.Address"/>

<mapping class="com.spy.hashset.User_info_data"/>





</session-factory>

</hibernate-configuration>


Address.java

package com.spy.hashset;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address
{

	String society;
	String city;
	int pincode;
	
	
	public String getSociety() 
	{
		return society;
	}
	
	public void setSociety(String society) 
	{
		this.society = society;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public int getPincode() 
	{
		return pincode;
	}
	
	public void setPincode(int pincode) 
	{
		this.pincode = pincode;
	}
	
}


User_info_data.java

package com.spy.hashset;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_info_data 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String userid;
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	String name;
	
	
	@ElementCollection
	Set<Address> listoAddress=new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public Set<Address> getListoAddress() {
		return listoAddress;
	}	

	public void setListoAddress(Set<Address> listoAddress) {
		this.listoAddress = listoAddress;
	}



}
CreateUserData.java

package com.spy.hashset;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateUserData 
{
	
	public static void main(String[] args)
     {
		
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





Output:

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into User_info_data (name, userid) values (?, ?)
Hibernate: insert into User_info_data_listoAddress (User_info_data_id, city, pincode, society) values (?, ?, ?, ?)
Hibernate: insert into User_info_data_listoAddress (User_info_data_id, city, pincode, society) values (?, ?, ?, ?)


User_Info_Data Table

Query:  select *from user_info_data


User_info_data_listoaddress table

Query: select *from user_info_data_listofaddress
 

In above table name user_info_data_listof address look likes weird name.
In above Example you can change table name and join column.
So make change in user_info_data.java
User_info_data.java

package com.spy.hashset;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class User_info_data 
{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String userid;
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	String name;
	
	
	@ElementCollection
	@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id")) 
	Set<Address> listoAddress=new HashSet<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Set<Address> getListoAddress() {
		return listoAddress;
	}


	public void setListoAddress(Set<Address> listoAddress) {
		this.listoAddress = listoAddress;
	}	
}

Output:

Hibernate: insert into User_info_data (name, userid) values (?, ?)

Hibernate: insert into user_address (user_id, city, pincode, society) values (?, ?, ?, ?)

Hibernate: insert into user_address (user_id, city, pincode, society) values (?, ?, ?, ?)


User_Info_Data Table
Query:  select *from user_info_data


User_address table:
Query:  select *from user_address
 	

	









Saving object using Array list.

Hibernate.cfg.xml

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

<!-- Database connection settings -->
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/test</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>


<!-- JDBC connection pool (use the built-in) -->
<property name="connection.pool_size">10</property>

<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">create</property>



<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>


<!-- Disable the second-level cache  -->
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>


<!-- Echo all executed SQL to stdout -->
<property name="show_sql">true</property>



<mapping class="com.spy.collection.Address"/>
<mapping class="com.spy.model.User_info"/>
<mapping class="com.spy.arraylist.User_info2"/>
<mapping class="com.spy.onetoonemap.Vehicle"/>
<mapping class="com.spy.onetoonemap.Userdetails1"/>



</session-factory>
</hibernate-configuration>

Address.java

package com.spy.collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
   public String street;
   public String city;
   public String state;
   public String pincode;
   
  
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}


User_info2.java

package com.spy.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.spy.collection.Address;

@Entity 
@Table (name="user_info2")
public class User_info2

{
   @Id @GeneratedValue(strategy=GenerationType.AUTO)
   
	private int userid;
               private String username;
   
      @JoinTable(name="user_address2", joinColumns=@JoinColumn(name="user_id"))     
      @GenericGenerator(name="hilo-gen",strategy="hilo")
      @CollectionId(columns ={@Column(name="address_index") }, 
                                                                     generator = "hilo-gen", 
                                                                     type = @Type(type="long"))
    Collection<Address> listofaddress=new ArrayList<Address>();
  
	public Collection<Address> getListofaddress() {
		return listofaddress;
	}
	public void setListofaddress(Collection<Address> listofaddress) {
		this.listofaddress = listofaddress;
	}
	public int getUserid() 
	{
		return userid;
	}
	public void setUserid(int userid) 
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}	
}





Testuserdata.java

package com.spy.arraylist
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
   user.setUsername("bhavesh");
	
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
  
  session.getTransaction().commit();
  session.close();
}

catch(HibernateException e)
{
	e.printStackTrace();
}
   
 }	
	

}

Output:
Hibernate: insert into user_info2 (username) values (?)
Hibernate: insert into user_address2 (user_id, address_index, city, pincode, state, street) values (?, ?, ?, ?, ?, ?)
Hibernate: insert into user_address2 (user_id, address_index, city, pincode, state, street) values (?, ?, ?, ?, ?, ?)


Hibernate: select user_info2x0_.userid as userid1_0_, user_info2x0_.username as username1_0_, listofaddr1_.user_id as user1_1_2_, listofaddr1_.city as city2_, listofaddr1_.pincode as pincode2_, listofaddr1_.state as state2_, listofaddr1_.street as street2_, listofaddr1_.address_index as address6_2_ from user_info2 user_info2x0_ left outer join user_address2 listofaddr1_ on user_info2x0_.userid=listofaddr1_.user_id where user_info2x0_.userid=?

See Table structure

User_info2 table

 

User_address2 table

 




Hibernate Query Language

To understand it lets create one table and insert some user entries.

Hibernate.cfg.xml

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

<session-factory>

<!-- Database connection settings -->
<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost:3306/test</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>

<!-- JDBC connection pool (use the built-in) -->
<property name="connection.pool_size">10</property>

<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">create</property>



<!-- SQL dialect -->
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

<!-- Disable the second-level cache  -->
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

<!-- Echo all executed SQL to stdout -->
<property name="show_sql">true</property>


<mapping class="com.spy.data.Employee12"/>
<mapping class="com.spy.operation.Userdata"/>



</session-factory>

</hibernate-configuration>


Userdata.java

package com.spy.operation;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedQuery;

@Entity
public class Userdata 
{
             @Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}

Testmain.java

package com.spy.operation;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testmain 
{
	public static void main(String[] args) 
	{
		for(int i=1;i<=10;i++)
		{
			
		Userdata user=new Userdata();
		user.setUser("user "+i); 
	
		}
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
                            //Saving object in database
		for(int i=1;i<=10;i++)
		{
			
		Userdata user=new Userdata();
		user.setUser("user "+i); 
		session.save(user);

		}
		session.getTransaction().commit();
		session.close();
			
	}
}
Output:
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)
Hibernate: insert into Userdata (user) values (?)





Userdata Table



Retrieving user using HQL


In our Previous Example we insert some data.
Note that before you tried this Example you should change hibernate.cgf.xml file
In previous example we have written create 
Now change it to update otherwise it will drop that table and re create it.
<!-- Drop and re-create the database schema on startup -->
<property name="hbm2ddl.auto">update</property>




Retrievedata.java

package com.spy.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spy.operation.Userdata;

public class RetrieveData 
{
public static void main(String[] args) 


{
	

Userdata user=new Userdata();
		
		
		
SessionFactory sf=new Configuration().configure().buildSessionFactory();

		
Session session=sf.openSession();
		
session.beginTransaction();
		
		 
Query query=session.createQuery("from Userdata");
		
List<Userdata> user1=query.list();
		
for (Userdata userdata : user1)
  {
		
	System.out.println(userdata.getUser());
			
  }
		
 }

}




Output:
Hibernate: select userdata0_.id as id1_, userdata0_.user as user1_ from Userdata userdata0_
user 1
user 2
user 3
user 4
user 5
user 6
user 7
user 8
user 9
user 10




Note: 
1. Note that here we have not written Select
2. In HQL you can also use where clause. See below Example.

Userdata.java

package com.spy.query;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spy.operation.Userdata;
public class RetrieveData 
{
	public static void main(String[] args) 
	{	
		//Userdata user=new Userdata();
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Userdata where id>7");

		List<Userdata> user1=query.list();
		
		for (Userdata userdata : user1)
		{
                	System.out.println(userdata.getUser());			
		}	
	}
}
 











