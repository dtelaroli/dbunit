package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;

import br.com.caelum.vraptor.plus.api.db.ListAllDb;
import br.com.flexait.caelum.vraptor.plus.dbunit.DbUnit;

public class DefaultListAllDbTest {

	private ListAllDb db;
	
	@Before
	public void setUp() throws Exception {
		Transaction tx = Ebean.beginTransaction();
		DbUnit dbUnit = new DbUnit(tx.getConnection());
		dbUnit.init(MyModel.class);
		db = new DefaultListAllDb();
	}
	
	@After
	public void tearDown() {
		Ebean.commitTransaction();
	}

	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = db.all(MyModel.class);
		assertThat(all, notNullValue());
		assertThat(all.get(0).getId(), equalTo(1L));
	}

}
