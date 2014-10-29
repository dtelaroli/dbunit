package br.com.caelum.vraptor.dbunit.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	public HibernateConnection() {
	}
	
	public Session getSession() {
		Configuration configuration = getConfiguration();
		StandardServiceRegistry serviceRegistry = getServiceRegistry(configuration);
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory.openSession();
	}

	private StandardServiceRegistry getServiceRegistry(Configuration configuration) {
		return new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties()).build();
	}

	private Configuration getConfiguration() {
		return new Configuration().configure();
	}

}
