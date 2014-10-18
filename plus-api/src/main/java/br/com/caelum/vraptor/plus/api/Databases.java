package br.com.caelum.vraptor.plus.api;

import br.com.caelum.vraptor.plus.api.db.ListAllDb;
import br.com.caelum.vraptor.plus.api.db.LoadDb;
import br.com.caelum.vraptor.plus.api.db.PaginateDb;
import br.com.caelum.vraptor.plus.api.db.RemoveDb;
import br.com.caelum.vraptor.plus.api.db.SaveDb;

public class Databases {

	public static Class<ListAllDb> listAll() {
		return ListAllDb.class;
	}

	public static Class<LoadDb> load() {
		return LoadDb.class;
	}
	
	public static Class<SaveDb> persist() {
		return SaveDb.class;
	}

	public static Class<PaginateDb> paginate() {
		return PaginateDb.class;
	}

	public static Class<RemoveDb> remove() {
		return RemoveDb.class;
	}

}
