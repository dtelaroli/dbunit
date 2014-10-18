package br.com.caelum.vraptor.plus.api.db;

import br.com.caelum.vraptor.plus.api.Db;

public interface LoadDb extends Db {

	<T> T find(Class<T> type, long id);

}
