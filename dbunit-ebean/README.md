# VRaptor DBUnit Ebean Implementation

For integration tests with Ebean

## Install

### Dependencies

```xml
<properties>
	<!-- Or latest -->
	<dbunit.version>2.5.0</dbunit.version>
	<h2.version>1.4.181</h2.version>
	<ebean.version>4.1.6</ebean.version>
</properties>
	
<dependency>
	<groupId>br.com.caelum.vraptor</groupId>
	<artifactId>dbunit-ebean</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>

<dependency>
	<groupId>org.dbunit</groupId>
	<artifactId>dbunit</artifactId>
	<version>${dbunit.version}</version>
</dependency>
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<version>${h2.version}</version>
</dependency>
<!-- Ebean Implementation -->
<dependency>
	<groupId>org.avaje.ebeanorm</groupId>
	<artifactId>avaje-ebeanorm</artifactId>
	<version>${ebean.version}</version>
</dependency>
```

### Ebean with H2

<pre>src/test/resources/ebean.properties</pre>

```INI
ebean.ddl.generate=true  
ebean.ddl.run=true
  
ebean.debug.sql=true  
ebean.debug.lazyload=false  
  
ebean.logging=all  
ebean.logging.logfilesharing=all  
ebean.logging.directory=logs  
ebean.logging.iud=sql  
ebean.logging.query=sql  
ebean.logging.sqlquery=sql  
ebean.logging.txnCommit=none  
  
datasource.default=h2  
  
datasource.h2.username=sa  
datasource.h2.password=  
datasource.h2.databaseUrl=jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1  
datasource.h2.databaseDriver=org.h2.Driver  
datasource.h2.minConnections=1  
datasource.h2.maxConnections=25  
datasource.h2.heartbeatsql=select 1  
datasource.h2.isolationlevel=read_committed  
```

## Usage

```Java
public class DbUnitEBeanTest {

	private DbUnit db;
	
	@Before
	public void setUp() throws Exception {
		db = new DbUnitEbean();
	}
	
	@Test
	public void shouldInitTableMyModel() throws Exception {
		db.init(MyModel.class);
		
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}

}
```
