package br.com.caelum.vraptor.plus.dbunit;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.dbunit.DbUnit;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

public class DbUnitTest {

	private DbUnit db;
	
	@Before
	public void setUp() throws Exception {
		db = new DbUnit(Ebean.beginTransaction().getConnection());
	}
	
	@Test
	public void shouldInitTableMyModel() throws Exception {
		Ebean.currentTransaction();
		db.init(MyModel.class);
		Ebean.commitTransaction();
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}
	
	@Test
	public void shouldCleanDatabase() throws Exception {
		Ebean.currentTransaction();
		db.init(MyModel.class);
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));

		db.clean();
		Ebean.commitTransaction();
		Ebean.endTransaction();
		
		assertThat(Ebean.find(MyModel.class, 1L), nullValue());
	}

}
