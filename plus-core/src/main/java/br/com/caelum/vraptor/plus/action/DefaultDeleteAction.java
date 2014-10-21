package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.delete;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;

public class DefaultDeleteAction implements DeleteAction {

	private final Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultDeleteAction() {
		this(null);
	}

	@Inject
	public DefaultDeleteAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> void by(Class<T> type, Long id) {
		db.use(delete()).by(type, id);
	}

}
