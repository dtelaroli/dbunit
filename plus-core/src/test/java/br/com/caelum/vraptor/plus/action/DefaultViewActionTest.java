package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.remove;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.RemoveAction;
import br.com.caelum.vraptor.plus.api.db.RemoveDb;

public class DefaultViewActionTest {

	private RemoveAction act;
	@Mock private Database db;
	@Mock private RemoveDb removeDb;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		doThrow(Exception.class).when(removeDb).by(null, 0l);
		
		when(db.use(remove())).thenReturn(removeDb);
		
		act = new DefaultRemoveAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		act.by(MyModel.class, 1l);
	}
	
	@Test(expected = Exception.class)
	public void shouldReturnExceptionIfInvalid() {
		act.by(null, 0l);
	}

}
