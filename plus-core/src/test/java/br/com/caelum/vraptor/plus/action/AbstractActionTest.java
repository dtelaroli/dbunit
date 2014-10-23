package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;

public class AbstractActionTest {

	private AbstractAction act;
	@Mock private Result result;
	@Mock private Database db;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		act = new AbstractAction(result, db) {
		};		
	}

	@Test
	public void shouldReturnDbInstance() {
		assertThat(act.db(), instanceOf(Database.class));
	}
	
	@Test
	public void shouldReturnResultInstance() {
		assertThat(act.result(), instanceOf(Result.class));
	}

}
