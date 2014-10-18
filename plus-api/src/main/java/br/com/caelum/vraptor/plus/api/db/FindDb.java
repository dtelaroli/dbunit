package br.com.caelum.vraptor.plus.api.db;

import java.util.List;

import br.com.caelum.vraptor.plus.api.Db;

public interface FindDb extends Db {

	<T> List<T> findAll(Class<T> type);

	<T> List<T> findPaginate(Class<T> type, int first, int limit);

	<T> T find(Class<T> type, long id);

}
