package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.PaginateDb;
import br.com.flexait.caelum.vraptor.plus.dbunit.DbUnit;
import br.com.flexait.caelum.vraptor.plus.dbunit.DbUnitEbean;

public class DefaultPaginateDbTest {

	private PaginateDb db;
	
	@Before
	public void setUp() throws Exception {
		DbUnit dbUnit = new DbUnitEbean();
		dbUnit.init(MyModel.class);
		db = new DefaultPaginateDb();
	}
	
	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = db.all(MyModel.class, 0, 2);
		assertThat(all, notNullValue());
		assertThat(all.get(1).getId(), equalTo(2L));
		assertThat(all.size(), equalTo(2));
	}

}
