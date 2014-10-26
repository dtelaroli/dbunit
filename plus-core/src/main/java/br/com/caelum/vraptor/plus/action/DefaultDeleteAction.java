package br.com.caelum.vraptor.plus.action;

import static br.com.caelum.vraptor.plus.api.Databases.delete;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;

public class DefaultDeleteAction extends AbstractAction implements DeleteAction {

	private static final String SUCCESS_MESSAGE = "success.delete";
	private Integer dbObject;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultDeleteAction() {
		this(null, null);
	}

	@Inject
	public DefaultDeleteAction(Result result, Database db) {
		super(result, db);
	}

	@Override
	public <T> DeleteAction by(Class<T> type, Object id) {
		execute(type, id);
		return this;
	}

	private <T> void execute(Class<T> type, Object id) {
		dbObject = db().use(delete()).by(type, id);
		if(message() == null) {
			withMessage(SUCCESS_MESSAGE);
		}
	}

	@Override
	protected Object dbObject() {
		return dbObject;
	}

}
