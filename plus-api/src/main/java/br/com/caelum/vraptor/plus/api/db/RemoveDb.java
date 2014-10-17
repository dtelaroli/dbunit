package br.com.caelum.vraptor.plus.api.db;

import br.com.caelum.vraptor.plus.api.Db;

public interface RemoveDb extends Db {

	<T> void by(Class<T> type, long id);
	
}
