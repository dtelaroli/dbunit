package br.com.flexait.caelum.vraptor.plus.dbunit;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

public class DbUnitTest {

	private DbUnit db;
	
	@Before
	public void setUp() throws Exception {
		Transaction tx = Ebean.beginTransaction();
		db = new DbUnit(tx.getConnection());
	}
	
	@After
	public void tearDown() {
		Ebean.commitTransaction();
	}

	@Test
	public void shouldInitTableMyModel() throws Exception {
		db.init(MyModel.class);
		
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}

}
