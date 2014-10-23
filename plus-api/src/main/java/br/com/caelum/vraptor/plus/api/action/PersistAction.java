package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface PersistAction extends Act {

	<T> PersistAction save(T object);

	<T> T andRedirect(Class<T> controller);
	
	<T> T andReturn();

}
