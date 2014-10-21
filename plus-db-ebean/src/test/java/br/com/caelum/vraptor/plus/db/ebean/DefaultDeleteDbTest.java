package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.DeleteDb;
import br.com.caelum.vraptor.plus.dbunit.DbUnit;
import br.com.caelum.vraptor.plus.dbunit.DbUnitEbean;

import com.avaje.ebean.Ebean;

public class DefaultDeleteDbTest {

	private DeleteDb db;
	
	@Before
	public void setUp() throws Exception {
		DbUnit dbUnit = new DbUnitEbean();
		dbUnit.init(MyModel.class);
		db = new DefaultDeleteDb();
	}
	
	@Test
	public void shouldRemoveMyModel() {
		int by = db.by(MyModel.class, 1L);
		assertThat(by, equalTo(1));
		assertThat(Ebean.find(MyModel.class, 1L), nullValue());
	}

}
