package br.com.caelum.vraptor.plus.api.db;

import br.com.caelum.vraptor.plus.api.Db;

public interface PersistDb extends Db {

	<T> T save(T object);

}
