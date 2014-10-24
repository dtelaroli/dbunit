package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.LoadAction;

public class DefaultLoadAction extends AbstractAction implements LoadAction {

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultLoadAction() {
		this(null, null);
	}
	
	@Inject
	public DefaultLoadAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> T by(Class<T> type, Object id) {
		return db().use(find()).by(type, id);
	}

}
