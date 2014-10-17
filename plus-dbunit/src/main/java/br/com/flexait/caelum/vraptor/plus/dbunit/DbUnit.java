package br.com.flexait.caelum.vraptor.plus.dbunit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DbUnit {

	private static final String DATASOURCE_PATH = "src/test/resources/datasets/";
	private final Connection conn;

	public DbUnit(Connection conn) {
		this.conn = conn;
	}

	@SafeVarargs
	public final <T> void init(Class<T>... types) throws Exception {
		for (Class<T> type : types) {
			initOne(type);
		}
	}

	protected <T> void initOne(Class<T> type) throws DatabaseUnitException, SQLException, FileNotFoundException {
		DatabaseOperation.INSERT.execute(getConnection(), getDataSet(type));
	}

	protected IDatabaseConnection getConnection() throws DatabaseUnitException {
		return new DatabaseConnection(conn);
	}

	protected <T> IDataSet getDataSet(Class<T> type) throws FileNotFoundException, DataSetException {
		FileInputStream fileInputStream = new FileInputStream(DATASOURCE_PATH + type.getSimpleName() + ".xml");
		return new FlatXmlDataSetBuilder().build(fileInputStream);
	}

}
