package br.com.caelum.vraptor.plus.db;

import br.com.caelum.vraptor.plus.Db;

public interface GetDb extends Db {

	<T> T get(Class<T> type, long id);

}
