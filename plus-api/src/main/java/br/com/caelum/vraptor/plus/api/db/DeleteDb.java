package br.com.caelum.vraptor.plus.api.db;

import br.com.caelum.vraptor.plus.api.Db;

public interface DeleteDb extends Db {

	<T> Integer by(Class<T> type, Object id);
	
}
