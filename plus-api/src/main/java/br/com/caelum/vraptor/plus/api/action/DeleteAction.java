package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface DeleteAction extends Act {

	<T> DeleteAction by(Class<T> type, Object id);

	<T> T andRedirectTo(Class<T> controller);
	
	<T> T andReturn();
	
}
