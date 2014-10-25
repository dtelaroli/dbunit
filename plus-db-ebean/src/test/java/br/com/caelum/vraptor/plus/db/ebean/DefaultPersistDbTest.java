package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.PersistDb;
import br.com.caelum.vraptor.plus.api.test.MyModel;
import br.com.caelum.vraptor.plus.dbunit.DbUnit;
import br.com.caelum.vraptor.plus.dbunit.DbUnitEbean;

import com.avaje.ebean.Ebean;

public class DefaultPersistDbTest {

	private PersistDb db;
	private DbUnit dbUnit;
	
	@Before
	public void setUp() throws Exception {
		dbUnit = new DbUnitEbean();
		dbUnit.init(MyModel.class);
		
		db = new DefaultPersistDb();
	}
	
	@Test
	public void shouldSaveNewMyModel() {
		MyModel model = new MyModel();
		model.setName("Foo");
		model = db.save(model);
		assertThat(model.getId(), equalTo(4L));
	}

	@Test
	public void shouldUpdateMyModel() {
		MyModel model = new MyModel(1L);
		model.setName("Bla");
		db.save(model);
		
		model = Ebean.find(MyModel.class, 1L);
		assertThat(model.getName(), equalTo("Bla"));
	}
	
	@Test
	public void shouldSaveNewMyModel2() {
		MyModel model = new MyModel();
		model.setName("Foo");
		model = db.insert(model);
		assertThat(model.getId(), equalTo(5L));
	}

	@Test
	public void shouldUpdateMyModel2() {
		MyModel model = new MyModel(1L);
		model.setName("Bla");
		db.update(model);
		
		model = Ebean.find(MyModel.class, 1L);
		assertThat(model.getName(), equalTo("Bla"));
	}
}
