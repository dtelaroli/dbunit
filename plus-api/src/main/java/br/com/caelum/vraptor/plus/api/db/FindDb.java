package br.com.caelum.vraptor.plus.api.db;

import java.util.List;

import br.com.caelum.vraptor.plus.api.Db;
import br.com.caelum.vraptor.plus.api.db.pagination.Page;

public interface FindDb extends Db {

	<T> List<T> all(Class<T> type);

	<T> Page<T> paginate(Class<T> type, int page, int limit);

	<T> T by(Class<T> type, Object id);

}
