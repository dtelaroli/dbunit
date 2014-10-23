package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;

public class DefaultPersistAction extends AbstractAction implements PersistAction {

	private Object objectDb;

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
	public <T> PersistAction save(T object) {
		execute(object);
		return this;
	}

	private <T> void execute(T object) {
		objectDb = db().use(persist()).save(object);
	}

	@Override
	protected Object dbObject() {
		return objectDb;
	}
	
}
