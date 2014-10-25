package br.com.caelum.vraptor.plus.api.test;

import static br.com.caelum.vraptor.plus.api.Databases.delete;
import static br.com.caelum.vraptor.plus.api.Databases.find;
import static br.com.caelum.vraptor.plus.api.Databases.persist;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.db.IModel;

import com.avaje.ebean.Model;

public class MockDatabaseTest {

	Database mock;
	
	@Before
	public void setUp() throws Exception {
		mock = new MockDatabase();
	}

	@Test
	public void shouldNotThrowNullPointersOnFindDbAll() {
		mock.use(find()).all(Model.class);
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbPersist() {
		mock.use(persist()).save(new IModel() {
			@Override
			public Object getId() {
				return null;
			}});
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbInsert() {
		mock.use(persist()).insert(new MyModel());
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbUpdate() {
		mock.use(persist()).update(new MyModel());
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbDelete() {
		mock.use(delete()).by(Model.class, 1L);
	}

}
