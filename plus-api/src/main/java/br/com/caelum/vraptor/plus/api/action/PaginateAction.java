package br.com.caelum.vraptor.plus.api.action;

import java.util.List;

import br.com.caelum.vraptor.plus.api.Act;

public interface PaginateAction extends Act {

	<T> List<T> all(Class<T> type);

	PaginateAction first(int first);

	PaginateAction limit(int limit);
	
}
