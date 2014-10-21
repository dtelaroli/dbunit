package br.com.caelum.vraptor.plus.api.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.Action;

@Vetoed
public class MockAction extends AbstractMock implements Action {

	@Override
	public <T extends Act> T use(Class<T> act) {
		return getProxifier().proxify(act, returnOnFinalMethods(act));
	}
	
}
