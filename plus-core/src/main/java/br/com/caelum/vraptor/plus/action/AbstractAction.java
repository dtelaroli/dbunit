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

	public Database db() {
		return db;
	}

	public Result result() {
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> T andReturn() {
		return (T) dbObject();
	}

	protected Object dbObject() {
		throw new UnsupportedOperationException("Not implemented");
	}

	public <T> T andRedirectTo(Class<T> controller) {
		return result().redirectTo(controller);
	}
}
