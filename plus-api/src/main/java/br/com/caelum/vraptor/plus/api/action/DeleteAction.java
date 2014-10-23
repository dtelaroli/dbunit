package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface DeleteAction extends Act {

	<T> void by(Class<T> type, Object id);

	<T> T andRedirect(Class<T> controller, Object id);
	
}
