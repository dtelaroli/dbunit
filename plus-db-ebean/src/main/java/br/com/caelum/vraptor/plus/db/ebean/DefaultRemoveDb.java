package br.com.caelum.vraptor.plus.db.ebean;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.RemoveDb;

public class DefaultRemoveDb implements RemoveDb {

	public DefaultRemoveDb() {
	}
	
	@Override
	public <T> int by(Class<T> type, long id) {
		return Ebean.delete(type, id);
	}

}
