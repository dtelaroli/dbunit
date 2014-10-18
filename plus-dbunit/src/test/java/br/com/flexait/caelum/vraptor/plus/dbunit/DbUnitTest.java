package br.com.flexait.caelum.vraptor.plus.dbunit;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

public class DbUnitTest {

	private DbUnit db;
	private Transaction tx;
	
	@Before
	public void setUp() throws Exception {
		tx = Ebean.beginTransaction();
		db = new DbUnit(tx.getConnection());
	}
	
	@Test
	public void shouldInitTableMyModel() throws Exception {
		db.init(MyModel.class);
		tx.commit();
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}
	
	@Test
	public void shouldCleanDatabase() throws Exception {
		db.init(MyModel.class);
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));

		db.clean();
		tx.addModification("my_model", false, false, true);
		tx.commit();
		
		assertThat(Ebean.find(MyModel.class, 1L), nullValue());
	}

}
