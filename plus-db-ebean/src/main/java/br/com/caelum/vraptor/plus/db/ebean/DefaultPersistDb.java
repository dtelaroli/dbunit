package br.com.caelum.vraptor.plus.db.ebean;

import br.com.caelum.vraptor.plus.api.db.PersistDb;

import com.avaje.ebean.Ebean;

public class DefaultPersistDb implements PersistDb {

	@Override
	public <T> T save(T object) {
		Ebean.save(object);
		return object;
	}

}
