package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.ListAllDb;

public class DefaultListAllDbTest {

	private ListAllDb db;
	
	@Before
	public void setUp() throws Exception {
		db = new DefaultListAllDb();
	}

	@Test
	public void shouldReturnListOfMyModel() {
//		assertThat(db.all(MyModel.class), notNullValue());
	}

}
