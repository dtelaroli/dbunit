package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.delete;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;
import br.com.caelum.vraptor.plus.api.db.DeleteDb;
import br.com.caelum.vraptor.plus.api.test.MyController;
import br.com.caelum.vraptor.plus.api.test.MyModel;
import br.com.caelum.vraptor.util.test.MockResult;

public class DefaultDeleteActionTest {

	private DeleteAction act;
	@Mock private Database db;
	@Mock private DeleteDb removeDb;
	@Spy private Result result = new MockResult();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		doThrow(Exception.class).when(removeDb).by(null, 0l);
		
		when(db.use(delete())).thenReturn(removeDb);
		when(result.redirectTo(MyController.class)).thenReturn(new MyController());
		when(removeDb.by(MyModel.class, 1l)).thenReturn(1);
		
		act = new DefaultDeleteAction(result, db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		int i = act.by(MyModel.class, 1l).andReturn();
		assertThat(i, equalTo(1));
	}
	
	@Test
	public void shouldReturnControllerInstance() {
		MyController controller = act.by(MyModel.class, 1l).andRedirectTo(MyController.class);
		assertThat(controller, instanceOf(MyController.class));
	}
	
	@Test
	public void shouldAddMessageOnSuccess() {
		act.by(MyModel.class, 1l);
		assertThat(result.included().get("message"), equalTo("success.delete"));
	}
	
	@Test
	public void shouldAddMessageChanged() {
		act.by(MyModel.class, 1l).withMessage("foo");
		assertThat(result.included().get("message"), equalTo("foo"));
	}
	
	@Test
	public void shouldSetMessage() {
		act.withMessage("bar");
		assertThat(result.included().get("message"), equalTo("bar"));
	}
	
	@Test(expected = Exception.class)
	public void shouldReturnExceptionIfInvalid() {
		act.by(null, 0l);
	}
	
}
