package br.com.caelum.vraptor.plus.action;

import java.util.List;

import br.com.caelum.vraptor.plus.Act;

public interface ListAllAction extends Act {

	<T> List<T> all(Class<T> type);
	
}
