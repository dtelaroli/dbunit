package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.load;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.ViewAction;

public class DefaultViewAction implements ViewAction {

	private final Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultViewAction() {
		this(null);
	}
	
	@Inject
	public DefaultViewAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> T get(Class<T> type, long id) {
		return db.use(load()).get(type, id);
	}

}
