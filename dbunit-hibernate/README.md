# DBUnit Hibernate Implementation

For integration tests with Hibernate

## Install

### Dependencies

```xml
<properties>
	<!-- Or latest -->
	<dbunit.version>2.5.0</dbunit.version>
	<h2.version>1.4.181</h2.version>
	<hibernate.version>4.3.6</hibernate.version>
</properties>
	
<dependency>
	<groupId>br.com.caelum.vraptor</groupId>
	<artifactId>dbunit-hibernate</artifactId>
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
<!-- Hibernate Implementation -->
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-core</artifactId>
	<version>${hibernate.version}</version>
</dependency>
```

### Hibernate with H2

File `src/test/resources/hibernate.cfg.xml`

```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">org.h2.Driver</property>
        <property name="hibernate.connection.url">jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1</property>
        <property name="hibernate.connection.username">sa</property>
        <property name="hibernate.connection.password"></property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="hibernate.connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.H2Dialect</property>

        <!-- Enable Hibernate's automatic session context management -->
        <property name="hibernate.current_session_context_class">thread</property>

        <!-- Disable the second-level cache  -->
        <property name="hibernate.cache.provider_class">org.hibernate.cache.internal.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="hibernate.show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hibernate.hbm2ddl.auto">update</property>

        <mapping class="models.MyModel"/>
    </session-factory>
</hibernate-configuration>

```

### DbUnit Datasets

Default folder: `src/test/resources/datasets`

Create a xml file with model name like this [MyModel.xml](https://github.com/dtelaroli/dbunit/blob/master/dbunit-hibernate/src/test/resources/datasets/MyModel.xml)

[MyModel.java](https://github.com/dtelaroli/dbunit/blob/master/dbunit-hibernate/src/main/java/br/com/caelum/vraptor/dbunit/api/MyModel.java)

## Usage

```Java
public class DbUnitHibernateTest {

	private DbUnitHibernate db;
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		db = new DbUnitHibernate();
		session = db.getSession();
	}

	@Test
	public void shouldReturnSession() {
		assertThat(session, instanceOf(Session.class));
		assertThat(session.isOpen(), equalTo(true));
	}
	
	@Test
	public void shouldInitDataBase() throws Exception {
		db.init(MyModel.class);
		
		MyModel model = (MyModel) session.load(MyModel.class, 1L);
		assertThat(model, instanceOf(MyModel.class));
		assertThat(model.getName(), equalTo("Name 1"));
	}
	
	@Test
	public void shouldInsertItem() throws Exception {
		db.init(MyModel.class);
		
		MyModel model = new MyModel();
		model.setName("Name 2");
		
		Transaction tx = session.beginTransaction();
		MyModel saved = (MyModel) session.merge(model);
		tx.commit();
		
		assertThat(saved.getId(), equalTo(2L));
	}

}
```
