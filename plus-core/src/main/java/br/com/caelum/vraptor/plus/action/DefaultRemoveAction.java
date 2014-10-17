package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.Databases.remove;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.Database;

public class DefaultRemoveAction implements RemoveAction {

	private final Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultRemoveAction() {
		this(null);
	}

	@Inject
	public DefaultRemoveAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> void by(Class<T> type, Long id) {
		db.use(remove()).by(type, id);
	}

}
