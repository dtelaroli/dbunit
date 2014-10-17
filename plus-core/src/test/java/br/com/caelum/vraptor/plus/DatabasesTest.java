package br.com.caelum.vraptor.plus;

import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.db.ListAllDb;
import br.com.caelum.vraptor.plus.db.LoadDb;
import br.com.caelum.vraptor.plus.db.PaginateDb;
import br.com.caelum.vraptor.plus.db.RemoveDb;

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
