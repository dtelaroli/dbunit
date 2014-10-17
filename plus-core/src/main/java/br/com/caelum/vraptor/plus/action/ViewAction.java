package br.com.caelum.vraptor.plus.action;

import br.com.caelum.vraptor.plus.Act;

public interface ViewAction extends Act {

	<T> T get(Class<T> type, long id);
	
}
