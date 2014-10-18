package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.SaveAction;

public class DefaultSaveAction implements SaveAction {

	private Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultSaveAction() {
		this(null);
	}

	@Inject
	public DefaultSaveAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> T save(T object) {
		return db.use(persist()).save(object);
	}

}
