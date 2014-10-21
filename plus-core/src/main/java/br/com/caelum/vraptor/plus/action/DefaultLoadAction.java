package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.LoadAction;

public class DefaultLoadAction implements LoadAction {

	private final Database db;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultLoadAction() {
		this(null);
	}
	
	@Inject
	public DefaultLoadAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> T by(Class<T> type, long id) {
		return db.use(find()).by(type, id);
	}

}
