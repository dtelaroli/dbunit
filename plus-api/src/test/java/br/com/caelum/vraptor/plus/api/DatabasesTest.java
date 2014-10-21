package br.com.caelum.vraptor.plus.api;

import static br.com.caelum.vraptor.plus.api.Databases.find;
import static br.com.caelum.vraptor.plus.api.Databases.persist;
import static br.com.caelum.vraptor.plus.api.Databases.delete;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.api.db.DeleteDb;
import br.com.caelum.vraptor.plus.api.db.PersistDb;

public class DatabasesTest {

	@Test
	public void shouldReturnListAllDb() {
		assertThat(find(), typeCompatibleWith(FindDb.class));
	}
	
	@Test
	public void shouldReturnSaveDb() {
		assertThat(persist(), typeCompatibleWith(PersistDb.class));
	}

	@Test
	public void shouldReturnRemoveDb() {
		assertThat(delete(), typeCompatibleWith(DeleteDb.class));
	}

}
