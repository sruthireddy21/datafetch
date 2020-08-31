package com.company.annotations;

import org.hibernate.AnnotationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.company.annotations.UserDetails;
import com.company.annotations.Vehicle;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.company.annotations.Vehicle;
import com.company.annotations.HibernateSessionsManagement;

public class TestDemo {
	static Transaction tx = null;
	public static SessionFactory factory;
	static Session session = null;

	public static void main(String[] args) {
		ServiceRegistry serviceRegistry;
		try {

			Configuration config = new Configuration();
			config.configure();
			config.addAnnotatedClass(Vehicle.class);

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			factory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Session session = factory.openSession();
		tx = session.beginTransaction();
		UserDetails user = new UserDetails();
		Vehicle vehicle = new Vehicle(); 
		Vehicle vehicle2 = new Vehicle(); 
		vehicle.setVehicleId(0012);
		vehicle.setVehicleName("BMW Car"); 
		vehicle.setUser(user); 
		vehicle.setVehicleId(0013);
		vehicle2.setVehicleName("AUDI Car"); 
		vehicle2.setUser(user);
		user.setUserName("sruthireddy"); 
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
