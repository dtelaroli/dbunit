package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.find;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;
import br.com.caelum.vraptor.plus.api.db.pagination.Page;
import br.com.caelum.vraptor.plus.api.db.pagination.DefaultPageConfig;

public class DefaultPaginationAction extends AbstractAction implements PaginationAction {

	private int page = 1;
	private int limit;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultPaginationAction() {
		this(null, null, null);
	}
	
	@Inject
	public DefaultPaginationAction(Result result, Database db, DefaultPageConfig config) {
		super(result, db);
		limit = config.getLimit();
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
