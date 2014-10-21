package br.com.caelum.vraptor.plus.api.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.plus.api.Database;
import br.com.caelum.vraptor.plus.api.Db;

@Vetoed
public class MockDatabase extends AbstractMock implements Database {

	@Override
	public <T extends Db> T use(Class<T> db) {
		return getProxifier().proxify(db, returnOnFinalMethods(db));
	}
	
}
