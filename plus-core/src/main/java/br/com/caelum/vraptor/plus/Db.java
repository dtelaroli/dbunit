package br.com.caelum.vraptor.plus;

import java.util.List;

public interface Db {

	<T> List<T> all(Class<T> type);

}
