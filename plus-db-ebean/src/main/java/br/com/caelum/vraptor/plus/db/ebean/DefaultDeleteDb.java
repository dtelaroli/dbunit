package br.com.caelum.vraptor.plus.db.ebean;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.DeleteDb;

public class DefaultDeleteDb implements DeleteDb {

	public DefaultDeleteDb() {
	}
	
	@Override
	public <T> Integer by(Class<T> type, long id) {
		return Ebean.delete(type, id);
	}

}
