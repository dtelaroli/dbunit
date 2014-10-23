package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;

public class DefaultPersistAction extends AbstractAction implements PersistAction {

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPersistAction() {
		this(null, null);
	}

	@Inject
	public DefaultPersistAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> T save(T object) throws Exception {
		return execute(object);
	}

	private <T> T execute(T object) {
		return db().use(persist()).save(object);
	}
	
	@Override
	public <T, I> T andRedirect(Class<T> controller, I object) {
		execute(object);
		return result().redirectTo(controller);
	}

}
