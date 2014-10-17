package br.com.flexait.caelum.vraptor.plus.dbunit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.ext.mssql.MsSqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import com.avaje.ebean.annotation.Transactional;

public class DbUnit {

	private static final String DATASOURCE_PATH = "src/test/resources/datasets/";
	private final Connection conn;

	public DbUnit(Connection conn) {
		this.conn = conn;
	}

	@SafeVarargs
	@Transactional
	public final <T> void init(Class<T>... types) throws Exception {
		for (Class<T> type : types) {
			initOne(type);
		}
	}

	protected <T> void initOne(Class<T> type) throws DatabaseUnitException,
			SQLException, FileNotFoundException {
		DatabaseOperation.INSERT.execute(getConnection(), getDataSet(type));
	}

	protected IDatabaseConnection getConnection() throws DatabaseUnitException,
			SQLException {
		DatabaseConnection databaseConnection = new DatabaseConnection(conn);
		setDataTypeFactory(databaseConnection);
		return databaseConnection;
	}

	private void setDataTypeFactory(DatabaseConnection databaseConnection)
			throws SQLException {
		DefaultDataTypeFactory dataTypeFactory = null;

		String databaseProductName = conn.getMetaData()
				.getDatabaseProductName();

		switch (databaseProductName) {
		case "HSQL Database Engine":
			dataTypeFactory = new HsqldbDataTypeFactory();
			break;

		case "MySQL":
			dataTypeFactory = new MySqlDataTypeFactory();
			break;

		case "H2":
			dataTypeFactory = new H2DataTypeFactory();
			break;

		case "PostgreSQL":
			dataTypeFactory = new PostgresqlDataTypeFactory();
			break;

		case "Oracle":
			dataTypeFactory = new OracleDataTypeFactory();
			break;

		case "Microsoft SQL Server":
			dataTypeFactory = new MsSqlDataTypeFactory();
			break;

		default:
			throw new SQLException("Unknown DataTypeFactory");
		}

		if (dataTypeFactory != null) {
			databaseConnection.getConfig().setProperty(
					DatabaseConfig.PROPERTY_DATATYPE_FACTORY, dataTypeFactory);
		}
	}

	protected <T> IDataSet getDataSet(Class<T> type)
			throws FileNotFoundException, DataSetException {
		String name = DATASOURCE_PATH + type.getSimpleName() + ".xml";
		FileInputStream fileInputStream = new FileInputStream(name);

		return new FlatXmlDataSetBuilder().build(fileInputStream);
	}

}
