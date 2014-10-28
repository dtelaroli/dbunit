package br.com.caelum.vraptor.dbunit.ebean;

import br.com.caelum.vraptor.dbunit.api.DbUnit;

import com.avaje.ebean.Ebean;

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
