package br.com.caelum.vraptor.plus.api;

import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.api.db.DeleteDb;
import br.com.caelum.vraptor.plus.api.db.PersistDb;

public class Databases {

	public static Class<PersistDb> persist() {
		return PersistDb.class;
	}

	public static Class<FindDb> find() {
		return FindDb.class;
	}

	public static Class<DeleteDb> delete() {
		return DeleteDb.class;
	}

}
