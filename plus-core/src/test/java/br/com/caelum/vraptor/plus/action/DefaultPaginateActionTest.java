package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.plus.Database;
import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.db.PaginateDb;

public class DefaultPaginateActionTest {

	private PaginateAction act;
	@Mock private Database db;
	@Mock private PaginateDb listDb;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(listDb.all(MyModel.class, 10, 10)).thenReturn(Arrays.asList(new MyModel()));
		when(db.use(PaginateDb.class)).thenReturn(listDb);
		
		act = new DefaultPaginateAllAction(db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = act.first(10).limit(10).all(MyModel.class);
		assertThat(all, not(empty()));
		assertThat(all.get(0), instanceOf(MyModel.class));
	}

}
