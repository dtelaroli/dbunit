package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.plus.api.Act;

public interface RemoveAction extends Act {

	<T> void by(Class<T> type, Long id);
	
}
