package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;
import br.com.caelum.vraptor.plus.api.db.PersistDb;
import br.com.caelum.vraptor.plus.api.test.MyController;
import br.com.caelum.vraptor.plus.api.test.MyModel;

public class DefaultPersistActionTest {

	private PersistAction act;
	private MyModel model;
	@Mock private Database db;
	@Mock private PersistDb saveDb;
	@Mock private Result result;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		model = new MyModel();
		MyModel savedModel = new MyModel(1L);
		
		when(saveDb.save(model)).thenReturn(savedModel);
		when(db.use(persist())).thenReturn(saveDb);
		when(result.redirectTo(MyController.class)).thenReturn(new MyController());
		
		act = new DefaultPersistAction(result, db);
	}
	
	@Test
	public void shouldReturnSavedMyModel() {
		model = act.save(model).andReturn();
		assertThat(model.getId(), notNullValue());
	}

	@Test
	public void shouldReturnControllerInstance() {
		MyController controller = act.save(model).andRedirectTo(MyController.class);
		assertThat(controller, instanceOf(MyController.class));
	}
	
}
