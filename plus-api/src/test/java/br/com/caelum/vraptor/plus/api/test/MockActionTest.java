package br.com.caelum.vraptor.plus.api.test;

import static br.com.caelum.vraptor.plus.api.Actions.delete;
import static br.com.caelum.vraptor.plus.api.Actions.list;
import static br.com.caelum.vraptor.plus.api.Actions.load;
import static br.com.caelum.vraptor.plus.api.Actions.pagination;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.Action;

import com.avaje.ebean.Model;

public class MockActionTest {

	Action mock;
	
	@Before
	public void setUp() throws Exception {
		mock = new MockAction();
	}

	@Test
	public void shouldNotThrowNullPointersOnFindDbAll() {
		mock.use(list()).all(Model.class);
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbPersist() {
		mock.use(load()).by(Model.class, 1);
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbDelete() {
		mock.use(delete()).by(Model.class, 1L);
	}
	
	@Test
	public void shouldNotThrowNullPointersOnFindDbPaginate() {
		mock.use(pagination()).page(1).limit(10).paginate(Model.class);
	}

}
