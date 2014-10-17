package br.com.caelum.vraptor.plus.api.db;

import java.util.List;

import br.com.caelum.vraptor.plus.api.Db;

public interface ListAllDb extends Db {

	<T> List<T> all(Class<T> type);

}
