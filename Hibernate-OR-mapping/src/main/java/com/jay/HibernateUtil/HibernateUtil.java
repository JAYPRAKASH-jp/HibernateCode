package com.jay.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static HibernateUtil instance=new HibernateUtil();
	private static SessionFactory sessionfactory;
	
	public static HibernateUtil getInstance() {
		return instance;
	}
	
	private HibernateUtil() {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionfactory=configuration.buildSessionFactory();
		
	}
	
	public static Session getSession() {
		Session session=getInstance().sessionfactory.openSession();
		return session;
	}
	
	
	
	

}
