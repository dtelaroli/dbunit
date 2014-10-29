# DBUnit Hibernate Implementation

For integration tests with Hibernate

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

### Hibernate with H2

File `src/test/resources/hibernate.cfg.xml`

```xml

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
