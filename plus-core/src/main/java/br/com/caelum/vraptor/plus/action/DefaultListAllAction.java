package br.com.caelum.vraptor.plus.action;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.plus.Database;
import br.com.caelum.vraptor.plus.db.ListAllDb;

@RequestScoped
public class DefaultListAllAction implements ListAllAction {

	private final Database db;

	/**
	 * @deprecated
	 */
	protected DefaultListAllAction() {
		this(null);
	}

	@Inject
	public DefaultListAllAction(Database db) {
		this.db = db;
	}
	
	@Override
	public <T> List<T> all(Class<T> type) {
		return db.use(ListAllDb.class).all(type);
	}

}
