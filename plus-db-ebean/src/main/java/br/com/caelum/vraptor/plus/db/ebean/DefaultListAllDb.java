package br.com.caelum.vraptor.plus.db.ebean;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;

import br.com.caelum.vraptor.plus.api.db.ListAllDb;

public class DefaultListAllDb implements ListAllDb {

	public DefaultListAllDb() {
	}
	
	@Override
	public <T> List<T> all(Class<T> type) {
		return null;
	}

}
