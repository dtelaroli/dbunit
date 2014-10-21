package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.PersistDb;

public class DefaultPersistDbTest {

	private PersistDb db;
	
	@Before
	public void setUp() throws Exception {
		db = new DefaultPersistDb();
	}
	
	@Test
	public void shouldReturnListOfMyModel() {
		MyModel model = new MyModel();
		model.setName("Foo");
		model = db.save(model);
		assertThat(model.getId(), equalTo(4L));
	}

}
