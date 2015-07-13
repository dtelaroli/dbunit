package br.com.flexait.dbunit.ebean;

import com.avaje.ebean.Ebean;

import br.com.flexait.dbunit.api.DbUnit;

public class DbUnitEbean extends DbUnit {
	
	public DbUnitEbean() {
		super(Ebean.beginTransaction().getConnection());
	}

	@Override @SafeVarargs
	public final void init(Class<?>... types) throws Exception {
		super.init(types);
		Ebean.commitTransaction();
	}
	
}
