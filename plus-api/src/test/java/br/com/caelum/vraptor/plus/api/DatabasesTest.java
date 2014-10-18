package br.com.caelum.vraptor.plus.api;

import static br.com.caelum.vraptor.plus.api.Databases.find;
import static br.com.caelum.vraptor.plus.api.Databases.persist;
import static br.com.caelum.vraptor.plus.api.Databases.remove;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.api.db.RemoveDb;
import br.com.caelum.vraptor.plus.api.db.SaveDb;

public class DatabasesTest {

	@Test
	public void shouldReturnListAllDb() {
		assertThat(find(), typeCompatibleWith(FindDb.class));
	}
	
	@Test
	public void shouldReturnSaveDb() {
		assertThat(persist(), typeCompatibleWith(SaveDb.class));
	}

	@Test
	public void shouldReturnRemoveDb() {
		assertThat(remove(), typeCompatibleWith(RemoveDb.class));
	}

}
