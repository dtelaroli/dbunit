package br.com.caelum.vraptor.plus.api;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.list;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;
import static br.com.caelum.vraptor.plus.api.Actions.persist;
import static br.com.caelum.vraptor.plus.api.Actions.load;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.api.action.ListAllAction;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;
import br.com.caelum.vraptor.plus.api.action.PersistAction;
import br.com.caelum.vraptor.plus.api.action.LoadAction;

public class ActionsTest {

	@Test
	public void shouldReturnListAllAction() {
		assertThat(list(), typeCompatibleWith(ListAllAction.class));
	}
	
	@Test
	public void shouldReturnViewAction() {
		assertThat(load(), typeCompatibleWith(LoadAction.class));
	}
	
	@Test
	public void shouldReturnSaveAction() {
		assertThat(persist(), typeCompatibleWith(PersistAction.class));
	}
	
	@Test
	public void shouldReturnPaginateAction() {
		assertThat(pagination(), typeCompatibleWith(PaginationAction.class));
	}
	
	@Test
	public void shouldReturnRemoveAction() {
		assertThat(delete(), typeCompatibleWith(DeleteAction.class));
	}

}
