package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.LoadDb;
import br.com.flexait.caelum.vraptor.plus.dbunit.DbUnit;
import br.com.flexait.caelum.vraptor.plus.dbunit.DbUnitEbean;

public class DefaultLoadDbTest {

	private LoadDb db;
	
	@Before
	public void setUp() throws Exception {
		DbUnit dbUnit = new DbUnitEbean();
		dbUnit.init(MyModel.class);
		db = new DefaultLoadDb();
	}
	
	@Test
	public void shouldReturnListOfMyModel() {
		MyModel model = db.get(MyModel.class, 1L);
		assertThat(model.getId(), equalTo(1L));
	}

}
