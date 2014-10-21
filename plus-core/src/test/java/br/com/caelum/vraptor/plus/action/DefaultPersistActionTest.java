package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;
import br.com.caelum.vraptor.plus.api.db.PersistDb;

public class DefaultPersistActionTest {

	private PersistAction act;
	@Mock private Database db;
	@Mock private PersistDb saveDb;
	private MyModel model;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		model = new MyModel();
		MyModel savedModel = new MyModel(1L);
		
		when(saveDb.save(model)).thenReturn(savedModel);
		when(db.use(persist())).thenReturn(saveDb);
		
		act = new DefaultPersistAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		MyModel saved = act.save(model);
		assertThat(saved.getId(), equalTo(1L));
	}
	
}
