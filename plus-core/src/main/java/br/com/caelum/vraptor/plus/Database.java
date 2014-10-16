package br.com.caelum.vraptor.plus;

public interface Database {

	<T extends Db> T use(Class<T> db);
	
}
