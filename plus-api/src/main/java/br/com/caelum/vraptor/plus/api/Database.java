package br.com.caelum.vraptor.plus.api;

public interface Database {

	<T extends Db> T use(Class<T> db);
	
}
