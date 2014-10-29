# DBUnit Ebean Implementation

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

### Ebean Maven Enhancer Plugin

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.avaje.ebeanorm</groupId>
			<artifactId>avaje-ebeanorm-mavenenhancer</artifactId>
			<version>${ebean.version}</version>
			<configuration>
				<packages>you.package.model.**</packages>
				<transformArgs>debug=1</transformArgs>
			</configuration>
			<executions>
				<execution>
					<id>main</id>
					<phase>process-classes</phase>
					<goals>
						<goal>enhance</goal>
					</goals>
				</execution>
			</executions>
		</plugin>
	</plugins>
	<pluginManagement>
		<plugins>
			<!--This plugin's configuration is used to store Eclipse m2e settings only. It has no influence on the Maven build itself.-->
			<plugin>
				<groupId>org.eclipse.m2e</groupId>
				<artifactId>lifecycle-mapping</artifactId>
				<version>1.0.0</version>
				<configuration>
					<lifecycleMappingMetadata>
						<pluginExecutions>
							<pluginExecution>
								<pluginExecutionFilter>
									<groupId>org.avaje.ebeanorm</groupId>
									<artifactId>avaje-ebeanorm-mavenenhancer</artifactId>
									<versionRange>[${ebean.version},)</versionRange>
									<goals>
										<goal>enhance</goal>
									</goals>
								</pluginExecutionFilter>
								<action>
									<execute></execute>
								</action>
							</pluginExecution>
						</pluginExecutions>
					</lifecycleMappingMetadata>
				</configuration>
			</plugin>
		</plugins>
	</pluginManagement>		
</build>
```

### Ebean with H2

File `src/test/resources/ebean.properties`

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

### DbUnit Datasets

Default folder: `src/test/resources/datasets`

Create a xml file with model name like this [MyModel.xml](https://github.com/dtelaroli/dbunit/blob/master/dbunit-ebean/src/test/resources/datasets/MyModel.xml)

[MyModel.java](https://github.com/dtelaroli/vraptor-dbunit/blob/master/ebean/src/main/java/br/com/caelum/vraptor/dbunit/api/MyModel.java)

## Usage

```Java
public class DbUnitEBeanTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		new DbUnitEbean().init(MyModel.class);
	}
	
	@Test
	public void shouldInitTableMyModel() throws Exception {
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}

}
```
