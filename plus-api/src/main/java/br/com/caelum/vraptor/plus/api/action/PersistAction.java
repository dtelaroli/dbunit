package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.db.IModel;

public interface PersistAction extends Act {

	<T> PersistAction insert(T object);
	
	<T> PersistAction update(T object);

	PersistAction save(IModel object);

	<T> T andRedirectTo(Class<T> controller);
	
	<T> T andReturn();

}
