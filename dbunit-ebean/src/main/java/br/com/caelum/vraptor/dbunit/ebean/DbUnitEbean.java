package br.com.caelum.vraptor.dbunit.ebean;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;

import br.com.caelum.vraptor.dbunit.api.DbUnit;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.TxIsolation;

public class DbUnitEbean extends DbUnit {

	private static final Connection CONNECTION;
	
	static {
		CONNECTION = Ebean.beginTransaction(TxIsolation.READ_COMMITED).getConnection();
	}

	public DbUnitEbean() {
		super(CONNECTION);
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
