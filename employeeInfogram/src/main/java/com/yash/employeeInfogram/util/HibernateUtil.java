package com.yash.employeeInfogram.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
 
	public static void resourceCleanUp(Session session,Transaction tx) {
		if(session!=null) {
			session.flush();
			if(tx!=null) {
				tx.commit();
			}
			session.close();
		}
	}
}
