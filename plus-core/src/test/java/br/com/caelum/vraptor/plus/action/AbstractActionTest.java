package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.test.MyController;
import br.com.caelum.vraptor.plus.api.test.MyModel;

public class AbstractActionTest {

	private AbstractAction act;
	@Mock private Result result;
	@Mock private Database db;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(result.redirectTo(MyController.class)).thenReturn(new MyController());
		
		act = new AbstractAction(result, db) {
			@Override
			protected Object dbObject() {
				return new MyModel();
			}
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
	
	@Test
	public void shouldReturnObject() {
		assertThat(act.andReturn(), instanceOf(MyModel.class));
	}
	
	@Test
	public void shouldReturnControllerForRedirect() {
		assertThat(act.andRedirectTo(MyController.class), instanceOf(MyController.class));
	}

}
