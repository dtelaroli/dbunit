package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.delete;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;

public class DefaultDeleteAction extends AbstractAction implements DeleteAction {

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultDeleteAction() {
		this(null, null);
	}

	@Inject
	public DefaultDeleteAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> void by(Class<T> type, Object id) {
		execute(type, id);
	}

	private <T> void execute(Class<T> type, Object id) {
		db().use(delete()).by(type, id);
	}

	@Override
	public <T> T andRedirect(Class<T> controller, Object id) {
		execute(controller, id);
		return result().redirectTo(controller);
	}

}
