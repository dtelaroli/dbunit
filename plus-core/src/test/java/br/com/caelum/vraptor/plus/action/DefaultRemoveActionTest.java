package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.Database;
import br.com.caelum.vraptor.plus.db.GetDb;

public class DefaultRemoveActionTest {

	private ViewAction act;
	@Mock private Database db;
	@Mock private GetDb getDb;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(getDb.get(MyModel.class, 1L)).thenReturn(new MyModel());
		when(db.use(GetDb.class)).thenReturn(getDb);
		
		act = new DefaultViewAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		assertThat(act.get(MyModel.class, 1L), instanceOf(MyModel.class));
	}

}
