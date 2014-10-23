package br.com.caelum.vraptor.plus.db.ebean;

import br.com.caelum.vraptor.plus.api.db.DeleteDb;

import com.avaje.ebean.Ebean;

public class DefaultDeleteDb implements DeleteDb {

	public DefaultDeleteDb() {
	}
	
	@Override
	public <T> Integer by(Class<T> type, Object id) {
		return Ebean.delete(type, id);
	}

}
