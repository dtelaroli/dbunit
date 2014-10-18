package br.com.caelum.vraptor.plus.db.ebean;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.dbunit.DbUnit;
import br.com.caelum.vraptor.plus.dbunit.DbUnitEbean;

public class DefaultListAllDbTest {

	private FindDb db;
	
	@Before
	public void setUp() throws Exception {
		DbUnit dbUnit = new DbUnitEbean();
		dbUnit.init(MyModel.class);
		db = new DefaultFindDb();
	}
	
	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = db.findAll(MyModel.class);
		assertThat(all, notNullValue());
		assertThat(all.get(0).getId(), equalTo(1L));
	}
	
	@Test
	public void shouldReturnMyModel() {
		MyModel model = db.find(MyModel.class, 1L);
		assertThat(model.getId(), equalTo(1L));
	}
	
	@Test
	public void shouldReturnListPaginateOfMyModel() {
		List<MyModel> all = db.findPaginate(MyModel.class, 0, 2);
		assertThat(all, notNullValue());
		assertThat(all.get(1).getId(), equalTo(2L));
		assertThat(all.size(), equalTo(2));
	}

}
