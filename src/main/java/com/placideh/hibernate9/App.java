package com.placideh.hibernate9;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
    {
    	//SECOND LEVEL CACHE with QUERY
    
    	Object a =null;
    	Configuration con= new Configuration().configure()
    			.addAnnotatedClass(Alien.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session =sf.openSession();
    	session.beginTransaction();
    		
    	Query q1=session.createQuery(" from Alien where aid=102");
    	q1.setCacheable(true);
    	
    	 a=q1.uniqueResult();
    	System.out.println(a);
    	session.getTransaction().commit();
    	session.close();
    	
    	Session session2 =sf.openSession();
    	session2.beginTransaction();
    	Query q2=session2.createQuery("from Alien where aid=102");
    	q2.setCacheable(true);
    	System.out.println(q2.uniqueResult() );
    	
    	
		session2.getTransaction().commit();
    	session2.close();
    	  
	
		 
    	
    	
    }
}
