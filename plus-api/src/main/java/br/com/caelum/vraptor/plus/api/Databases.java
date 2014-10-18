package br.com.caelum.vraptor.plus.api;

import br.com.caelum.vraptor.plus.api.db.FindDb;
import br.com.caelum.vraptor.plus.api.db.RemoveDb;
import br.com.caelum.vraptor.plus.api.db.SaveDb;

public class Databases {

	public static Class<SaveDb> persist() {
		return SaveDb.class;
	}

	public static Class<FindDb> find() {
		return FindDb.class;
	}

	public static Class<RemoveDb> remove() {
		return RemoveDb.class;
	}

}
