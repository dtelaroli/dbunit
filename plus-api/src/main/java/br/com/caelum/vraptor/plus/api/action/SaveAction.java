package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface SaveAction extends Act {

	<T> T save(T object);

}
