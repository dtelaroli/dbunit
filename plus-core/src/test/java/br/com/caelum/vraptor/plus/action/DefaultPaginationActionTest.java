package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
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
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;
import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.api.test.MyModel;
import br.com.caelum.vraptor.util.test.MockResult;

public class DefaultPaginationActionTest {

	private PaginationAction act;
	@Mock private Database db;
	@Mock private FindDb findDb;
	@Spy private Result result = new MockResult();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(findDb.paginate(MyModel.class, 10, 10)).thenReturn(Arrays.asList(new MyModel()));
		when(db.use(find())).thenReturn(findDb);
		
		act = new DefaultPaginationAction(result, db);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = act.page(10).limit(10).all(MyModel.class);
		assertThat(all, not(empty()));
		assertThat(all.get(0), instanceOf(MyModel.class));
	}
	
	@Test
	public void shouldIncludeParameters() {
		act.page(10).limit(5);
		assertThat(result.included().get("page"), equalTo(10));
		assertThat(result.included().get("limit"), equalTo(5));
	}

}
