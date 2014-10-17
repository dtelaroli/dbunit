package br.com.caelum.vraptor.plus.db.ebean;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.LoadDb;

public class DefaultLoadDb implements LoadDb {

	@Override
	public <T> T get(Class<T> type, long id) {
		return Ebean.find(type, id);
	}

}
