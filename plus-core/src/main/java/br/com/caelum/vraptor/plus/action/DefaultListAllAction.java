package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.ListAllAction;

@RequestScoped
public class DefaultListAllAction implements ListAllAction {

	private final Database db;

	/**
	 * @deprecated CDI eyes-only
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
		return db.use(find()).all(type);
	}

}
