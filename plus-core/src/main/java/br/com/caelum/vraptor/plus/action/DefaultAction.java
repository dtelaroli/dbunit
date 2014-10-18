package br.com.caelum.vraptor.plus.action;

import javax.inject.Inject;

import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.Action;

public class DefaultAction implements Action {

	private final Container container;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected DefaultAction() {
		this(null);
	}
	
	@Inject
	public DefaultAction(Container container) {
		this.container = container;
	}

	@Override
	public <T extends Act> T use(Class<T> act) {
		return container.instanceFor(act);
	}

}
