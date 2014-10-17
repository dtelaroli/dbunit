package br.com.flexait.caelum.vraptor.plus.dbunit;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;

import com.avaje.ebean.Ebean;

public class DbUnitEbean extends DbUnit {

	public DbUnitEbean() {
		super(Ebean.beginTransaction().getConnection());
	}

	@Override
	protected <T> void initOne(Class<T> type) throws DatabaseUnitException,
			SQLException, FileNotFoundException {
		try {
			Ebean.currentTransaction();
			
			super.initOne(type);
			
			Ebean.commitTransaction();
		} finally {
			Ebean.endTransaction();
		}
	}

}
