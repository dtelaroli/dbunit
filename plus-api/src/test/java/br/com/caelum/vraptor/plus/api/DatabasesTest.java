package br.com.caelum.vraptor.plus.api;

import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.ListAllDb;
import br.com.caelum.vraptor.plus.api.db.LoadDb;
import br.com.caelum.vraptor.plus.api.db.PaginateDb;
import br.com.caelum.vraptor.plus.api.db.RemoveDb;

public class DatabasesTest {

	@Test
	public void shouldReturnListAllAction() {
		assertThat(Databases.listAll(), typeCompatibleWith(ListAllDb.class));
	}
	
	@Test
	public void shouldReturnViewAction() {
		assertThat(Databases.load(), typeCompatibleWith(LoadDb.class));
	}
	
	@Test
	public void shouldReturnPaginateAction() {
		assertThat(Databases.paginate(), typeCompatibleWith(PaginateDb.class));
	}
	
	@Test
	public void shouldReturnRemoveAction() {
		assertThat(Databases.remove(), typeCompatibleWith(RemoveDb.class));
	}

}
