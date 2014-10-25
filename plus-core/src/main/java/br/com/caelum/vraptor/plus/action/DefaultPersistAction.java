package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.persist;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PersistAction;
import br.com.caelum.vraptor.plus.api.db.IModel;

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
	public PersistAction save(IModel object) {
		objectDb = db().use(persist()).save(object);
		return this;
	}

	@Override
	public <T> PersistAction insert(T object) {
		objectDb = db().use(persist()).insert(object);
		return this;
	}
	
	@Override
	public <T> PersistAction update(T object) {
		objectDb = db().use(persist()).update(object);
		return this;
	}

	@Override
	protected Object dbObject() {
		return objectDb;
	}

}
