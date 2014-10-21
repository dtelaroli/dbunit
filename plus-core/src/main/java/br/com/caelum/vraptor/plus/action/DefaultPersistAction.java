package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;

public class DefaultPersistAction implements PersistAction {

	private Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPersistAction() {
		this(null);
	}

	@Inject
	public DefaultPersistAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> T save(T object) {
		return db.use(persist()).save(object);
	}

}
