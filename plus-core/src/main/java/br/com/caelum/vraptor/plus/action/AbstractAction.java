package br.com.caelum.vraptor.plus.action;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.Database;

public abstract class AbstractAction implements Act {

	private final Result result;
	private final Database db;

	public AbstractAction(Result result, Database db) {
		this.result = result;
		this.db = db;
	}

	@Override
	public Database db() {
		return db;
	}

	@Override
	public Result result() {
		return result;
	}
}
