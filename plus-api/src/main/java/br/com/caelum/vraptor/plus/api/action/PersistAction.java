package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface PersistAction extends Act {

	<T> T save(T object) throws Exception;

	<T, I> T andRedirect(Class<T> controller, I object);

}
