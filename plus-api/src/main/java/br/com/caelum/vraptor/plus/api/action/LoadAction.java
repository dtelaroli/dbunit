package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface LoadAction extends Act {

	<T> T by(Class<T> type, Object id);
	
}
