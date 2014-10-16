package br.com.caelum.vraptor.plus.action;

import br.com.caelum.vraptor.plus.Act;

public interface RemoveAction extends Act {

	<T> void by(Class<T> type, Long id);
	
}
