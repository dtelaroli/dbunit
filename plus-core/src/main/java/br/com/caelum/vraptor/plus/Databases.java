package br.com.caelum.vraptor.plus;

import br.com.caelum.vraptor.plus.db.LoadDb;
import br.com.caelum.vraptor.plus.db.ListAllDb;
import br.com.caelum.vraptor.plus.db.PaginateDb;
import br.com.caelum.vraptor.plus.db.RemoveDb;

public class Databases {

	public static Class<ListAllDb> listAll() {
		return ListAllDb.class;
	}

	public static Class<LoadDb> load() {
		return LoadDb.class;
	}

	public static Class<PaginateDb> paginate() {
		return PaginateDb.class;
	}

	public static Class<RemoveDb> remove() {
		return RemoveDb.class;
	}

}
