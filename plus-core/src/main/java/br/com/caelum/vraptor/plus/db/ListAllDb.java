package br.com.caelum.vraptor.plus.db;

import java.util.List;

import br.com.caelum.vraptor.plus.Db;

public interface ListAllDb extends Db {

	<T> List<T> all(Class<T> type);

}
