package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.Database;
import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.db.ListAllDb;

public class DefaultListAllActionTest {

	private ListAllAction act;
	@Mock private Database db;
	@Mock private ListAllDb listDb;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(listDb.all(MyModel.class)).thenReturn(Arrays.asList(new MyModel()));
		when(db.use(ListAllDb.class)).thenReturn(listDb);
		
		act = new DefaultListAllAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		assertThat(act.all(MyModel.class).get(0), instanceOf(MyModel.class));
	}

}
