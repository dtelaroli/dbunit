package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.ListAllAction;

@RequestScoped
public class DefaultListAllAction extends AbstractAction implements ListAllAction {

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultListAllAction() {
		this(null, null);
	}

	@Inject
	public DefaultListAllAction(Result result, Database db) {
		super(result, db);
	}
	
	@Override
	public <T> List<T> all(Class<T> type) {
		return db().use(find()).all(type);
	}
	
}
