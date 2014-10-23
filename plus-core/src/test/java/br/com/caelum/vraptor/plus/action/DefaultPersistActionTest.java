package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
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
		
		act = new DefaultPersistAction(result, db);
	}

	@Test
	public void shouldReturnListOfMyModel() throws Exception {
		MyModel saved = act.save(model);
		assertThat(saved.getId(), equalTo(1L));
	}
	
	@Test
	public void shouldReturnResultForRedirect() throws Exception {
		MyController controller = spy(new MyController());
		when(act.andRedirect(MyController.class, model)).thenReturn(controller);
		
		act.andRedirect(MyController.class, model).edit(1L);
		verify(result).redirectTo(MyController.class);
		verify(controller).edit(1L);
	}
	
}
