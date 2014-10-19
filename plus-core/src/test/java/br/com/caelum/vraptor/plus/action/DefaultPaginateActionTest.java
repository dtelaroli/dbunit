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

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.MyModel;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginateAction;
import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.util.test.MockResult;

public class DefaultPaginateActionTest {

	private PaginateAction act;
	@Mock private Database db;
	@Mock private FindDb findDb;
	private Result result;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		result = new MockResult();
		
		when(findDb.findPaginate(MyModel.class, 10, 10)).thenReturn(Arrays.asList(new MyModel()));
		when(db.use(find())).thenReturn(findDb);
		
		act = new DefaultPaginateAllAction(db, result);
	}

	@Test
	public void shouldReturnListOfMyModel() {
		List<MyModel> all = act.first(10).limit(10).all(MyModel.class);
		assertThat(all, not(empty()));
		assertThat(all.get(0), instanceOf(MyModel.class));
	}
	
	@Test
	public void shouldIncludeParameters() {
		act.first(10).limit(5);
		assertThat(result.included().get("first"), equalTo(10));
		assertThat(result.included().get("limit"), equalTo(5));
	}

}
