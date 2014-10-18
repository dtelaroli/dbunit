package br.com.caelum.vraptor.plus.api;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.listAll;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.save;
import static br.com.caelum.vraptor.plus.api.Actions.view;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.api.action.ListAllAction;
import br.com.caelum.vraptor.plus.api.action.PaginateAction;
import br.com.caelum.vraptor.plus.api.action.RemoveAction;
import br.com.caelum.vraptor.plus.api.action.SaveAction;
import br.com.caelum.vraptor.plus.api.action.ViewAction;

public class ActionsTest {

	@Test
	public void shouldReturnListAllAction() {
		assertThat(listAll(), typeCompatibleWith(ListAllAction.class));
	}
	
	@Test
	public void shouldReturnViewAction() {
		assertThat(view(), typeCompatibleWith(ViewAction.class));
	}
	
	@Test
	public void shouldReturnSaveAction() {
		assertThat(save(), typeCompatibleWith(SaveAction.class));
	}
	
	@Test
	public void shouldReturnPaginateAction() {
		assertThat(pagination(), typeCompatibleWith(PaginateAction.class));
	}
	
	@Test
	public void shouldReturnRemoveAction() {
		assertThat(delete(), typeCompatibleWith(RemoveAction.class));
	}

}
