package br.com.flexait.dbunit.ebean;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import models.MyModel;

import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;

import br.com.flexait.dbunit.api.DbUnit;
import br.com.flexait.dbunit.ebean.DbUnitEbean;

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
