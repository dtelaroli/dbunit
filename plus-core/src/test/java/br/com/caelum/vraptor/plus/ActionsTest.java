package br.com.caelum.vraptor.plus;

import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.Actions;
import br.com.caelum.vraptor.plus.action.ListAllAction;
import br.com.caelum.vraptor.plus.action.PaginateAction;
import br.com.caelum.vraptor.plus.action.RemoveAction;
import br.com.caelum.vraptor.plus.action.ViewAction;

public class ActionsTest {

	@Test
	public void shouldReturnListAllAction() {
		assertThat(Actions.listAll(), typeCompatibleWith(ListAllAction.class));
	}
	
	@Test
	public void shouldReturnViewAction() {
		assertThat(Actions.view(), typeCompatibleWith(ViewAction.class));
	}
	
	@Test
	public void shouldReturnPaginateAction() {
		assertThat(Actions.paginate(), typeCompatibleWith(PaginateAction.class));
	}
	
	@Test
	public void shouldReturnRemoveAction() {
		assertThat(Actions.remove(), typeCompatibleWith(RemoveAction.class));
	}

}
