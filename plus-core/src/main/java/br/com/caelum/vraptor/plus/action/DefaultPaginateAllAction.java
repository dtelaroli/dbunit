package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginateAction;

public class DefaultPaginateAllAction implements PaginateAction {

	private final Database db;
	private final Result result;
	private int first = 0;
	private int limit = 20;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPaginateAllAction() {
		this(null, null);
	}
	
	@Inject
	public DefaultPaginateAllAction(Database db, Result result) {
		this.db = db;
		this.result = result;
	}

	@Override
	public <T> List<T> all(Class<T> type) {
		return db.use(find()).findPaginate(type, first, limit);
	}

	@Override
	public PaginateAction first(int first) {
		result.include("first", first);
		this.first = first;
		return this;
	}

	@Override
	public PaginateAction limit(int limit) {
		result.include("limit", limit);
		this.limit = limit;
		return this;
	}

}
