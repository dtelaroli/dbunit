package br.com.caelum.vraptor.plus.db.ebean;

import br.com.caelum.vraptor.plus.api.db.SaveDb;

import com.avaje.ebean.Ebean;

public class DefaultSaveDb implements SaveDb {

	@Override
	public <T> T save(T object) {
		Ebean.save(object);
		return object;
	}

}
