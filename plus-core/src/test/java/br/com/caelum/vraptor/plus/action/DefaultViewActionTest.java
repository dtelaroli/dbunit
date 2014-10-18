package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.ViewAction;
import br.com.caelum.vraptor.plus.api.db.FindDb;

public class DefaultViewActionTest {

	private ViewAction act;
	@Mock private Database db;
	@Mock private FindDb findDb;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(findDb.find(MyModel.class, 1L)).thenReturn(new MyModel());
		when(db.use(find())).thenReturn(findDb);
		
		act = new DefaultViewAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		assertThat(act.get(MyModel.class, 1L), instanceOf(MyModel.class));
	}

}
