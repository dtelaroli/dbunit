package br.com.caelum.vraptor.plus.db;

import br.com.caelum.vraptor.plus.Db;

public interface RemoveDb extends Db {

	<T> void by(Class<T> type, long id);
	
}
