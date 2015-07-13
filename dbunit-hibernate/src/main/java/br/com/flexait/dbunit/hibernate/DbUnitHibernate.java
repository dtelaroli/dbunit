package br.com.flexait.dbunit.hibernate;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import br.com.flexait.dbunit.api.DbUnit;

public class DbUnitHibernate extends DbUnit {

	private static Session session;
	protected static Connection conn;

	static {
		session = new HibernateConnection().getSession();
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				conn = connection;				
			}
		});
	}
	
	public DbUnitHibernate() {
		super(conn);
	}

	public Session getSession() {
		return session;
	}
	
}
