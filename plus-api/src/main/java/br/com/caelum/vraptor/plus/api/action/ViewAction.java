package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface ViewAction extends Act {

	<T> T get(Class<T> type, long id);
	
}
