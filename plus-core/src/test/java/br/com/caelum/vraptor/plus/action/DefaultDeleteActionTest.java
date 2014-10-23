package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.delete;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;
import br.com.caelum.vraptor.plus.api.db.DeleteDb;
import br.com.caelum.vraptor.plus.api.test.MyController;
import br.com.caelum.vraptor.plus.api.test.MyModel;

public class DefaultDeleteActionTest {

	private DeleteAction act;
	@Mock private Database db;
	@Mock private DeleteDb removeDb;
	@Mock private Result result;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		doThrow(Exception.class).when(removeDb).by(null, 0l);
		
		when(db.use(delete())).thenReturn(removeDb);
		
		act = new DefaultDeleteAction(result, db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		act.by(MyModel.class, 1l);
	}
	
	@Test(expected = Exception.class)
	public void shouldReturnExceptionIfInvalid() {
		act.by(null, 0l);
	}
	
	@Test
	public void shouldReturnResultForRedirect() throws Exception {
		MyController controller = spy(new MyController());
		when(act.andRedirect(MyController.class, 1l)).thenReturn(controller);
		
		act.andRedirect(MyController.class, 1l).index();
		verify(result).redirectTo(MyController.class);
		verify(controller).index();
	}

}
