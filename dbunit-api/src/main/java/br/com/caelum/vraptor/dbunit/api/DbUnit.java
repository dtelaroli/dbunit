package br.com.caelum.vraptor.dbunit.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public class DbUnit {

	private static final String DATASOURCE_PATH = "src/test/resources/datasets/";
	private final Connection conn;
	private List<IDatabaseConnection> connections = new ArrayList<>();
	private List<IDataSet> dataSets = new ArrayList<>();

	public DbUnit(Connection conn) {
		this.conn = conn;
	}

	public void init(Class<?>... types) throws Exception {
		for (Class<?> type : types) {
			initOne(type);
		}
	}

	protected <T> void initOne(Class<T> type) throws DatabaseUnitException,
			SQLException, FileNotFoundException {
		IDataSet dataSet = getDataSet(type);
		IDatabaseConnection connection = getConnection();
		dataSets.add(dataSet);
		connections.add(connection);
		
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
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

	public void clean() throws DatabaseUnitException, SQLException {
		for (int i = 0; i < connections.size(); i++) {
			DatabaseOperation.DELETE.execute(connections.get(i), dataSets.get(i));
		}
	}

}
