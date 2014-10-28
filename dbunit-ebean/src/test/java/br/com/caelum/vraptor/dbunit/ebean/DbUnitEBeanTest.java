package br.com.caelum.vraptor.dbunit.ebean;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.dbunit.api.DbUnit;

import com.avaje.ebean.Ebean;

public class DbUnitEBeanTest {

	private DbUnit db;
	
	@Before
	public void setUp() throws Exception {
		db = new DbUnitEbean();
	}
	
	@Test
	public void shouldInitTableMyModel() throws Exception {
		db.init(MyModel.class);
		
		assertThat(Ebean.find(MyModel.class, 1L), instanceOf(MyModel.class));
	}
	
}
