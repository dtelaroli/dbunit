package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.SaveDb;

public class DefaultSaveDbTest {

	private SaveDb db;
	
	@Before
	public void setUp() throws Exception {
		db = new DefaultSaveDb();
	}
	
	@Test
	public void shouldReturnListOfMyModel() {
		MyModel model = new MyModel();
		model.setName("Foo");
		model = db.save(model);
		assertThat(model.getId(), equalTo(4L));
	}

}
