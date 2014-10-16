package br.com.caelum.vraptor.plus.action;

import java.util.List;

import br.com.caelum.vraptor.plus.Act;

public interface PaginateAction extends Act {

	<T> List<T> all(Class<T> type);

	PaginateAction first(int first);

	PaginateAction limit(int limit);
	
}
