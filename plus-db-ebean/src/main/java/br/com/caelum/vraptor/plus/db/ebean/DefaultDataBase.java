package br.com.caelum.vraptor.plus.db.ebean;

import javax.inject.Inject;

import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.Db;

public class DefaultDataBase implements Database {

	private final Container container;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultDataBase() {
		this(null);
	}
	
	@Inject
	public DefaultDataBase(Container container) {
		this.container = container;
	}

	@Override
	public <T extends Db> T use(Class<T> db) {
		return container.instanceFor(db);
	}

}
