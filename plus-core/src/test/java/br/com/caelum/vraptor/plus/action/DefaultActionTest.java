package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Actions.list;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.plus.api.Action;
import br.com.caelum.vraptor.plus.api.action.ListAllAction;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Validator;

public class DefaultActionTest {

	private Action act;
	@Mock private Container container;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(container.instanceFor(list())).thenReturn(new DefaultListAllAction());
		when(container.instanceFor(Result.class)).thenReturn(new MockResult());
		when(container.instanceFor(Validator.class)).thenReturn(new MockValidator());
		
		act = new DefaultAction(container);
	}

	@Test
	public void shouldReturnListAllActionInstance() {
		assertThat(act.use(list()), instanceOf(ListAllAction.class));
	}
	
	@Test
	public void shouldReturnResultInstance() {
		assertThat(act.result(), instanceOf(Result.class));
	}

}
