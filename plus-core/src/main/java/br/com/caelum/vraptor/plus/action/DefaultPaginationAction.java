package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;
import br.com.caelum.vraptor.plus.api.db.pagination.Page;

public class DefaultPaginationAction extends AbstractAction implements PaginationAction {

	private int page = 0;
	private int limit = 20;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPaginationAction() {
		this(null, null);
	}
	
	@Inject
	public DefaultPaginationAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> Page<T> paginate(Class<T> type) {
		return db().use(find()).paginate(type, page, limit);
	}

	@Override
	public PaginationAction page(int page) {
		this.page = page;
		return this;
	}

	@Override
	public PaginationAction limit(int limit) {
		this.limit = limit;
		return this;
	}

}
