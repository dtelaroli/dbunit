package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginateAction;

public class DefaultPaginateAllAction implements PaginateAction {

	private final Database db;
	private int first = 0;
	private int limit = 20;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPaginateAllAction() {
		this(null);
	}
	
	@Inject
	public DefaultPaginateAllAction(Database db) {
		this.db = db;
	}

	@Override
	public <T> List<T> all(Class<T> type) {
		return db.use(find()).findPaginate(type, first, limit);
	}

	@Override
	public PaginateAction first(int first) {
		this.first = first;
		return this;
	}

	@Override
	public PaginateAction limit(int limit) {
		this.limit = limit;
		return this;
	}

}
