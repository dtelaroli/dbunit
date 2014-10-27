package br.com.caelum.vraptor.plus.action;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.Action;
import br.com.caelum.vraptor.validator.Validator;

public class DefaultAction implements Action {

	private final Container container;
	private final Result result;
	private final Validator validator;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultAction() {
		this(null);
	}
	
	@Inject
	public DefaultAction(Container container) {
		this.container = container;
		result = container.instanceFor(Result.class);
		validator = container.instanceFor(Validator.class);
	}

	@Override
	public <T extends Act> T use(Class<T> act) {
		return container.instanceFor(act);
	}

	@Override
	public Result result() {
		return result;
	}

	@Override
	public Validator validator() {
		return validator;
	}

}
