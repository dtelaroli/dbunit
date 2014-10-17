package br.com.caelum.vraptor.plus.api;

import static br.com.caelum.vraptor.plus.api.Databases.listAll;
import static br.com.caelum.vraptor.plus.api.Databases.load;
import static br.com.caelum.vraptor.plus.api.Databases.paginate;
import static br.com.caelum.vraptor.plus.api.Databases.remove;
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
		assertThat(listAll(), typeCompatibleWith(ListAllDb.class));
	}
	
	@Test
	public void shouldReturnViewAction() {
		assertThat(load(), typeCompatibleWith(LoadDb.class));
	}
	
	@Test
	public void shouldReturnPaginateAction() {
		assertThat(paginate(), typeCompatibleWith(PaginateDb.class));
	}
	
	@Test
	public void shouldReturnRemoveAction() {
		assertThat(remove(), typeCompatibleWith(RemoveDb.class));
	}

}
