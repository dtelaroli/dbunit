package br.com.caelum.vraptor.plus.db.ebean;

import static br.com.caelum.vraptor.plus.api.Databases.listAll;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.db.FindDb;

public class DefaultDatabaseTest {

	private Database dbs;
	@Mock private Container container;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(container.instanceFor(listAll())).thenReturn(new DefaultFindDb());
		
		dbs = new DefaultDataBase(container);
	}

	@Test
	public <T> void shouldReturnListAllActionInstance() {
		assertThat(dbs.use(listAll()), instanceOf(FindDb.class));
	}

}
