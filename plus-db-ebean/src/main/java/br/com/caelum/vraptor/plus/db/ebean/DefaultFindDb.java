package br.com.caelum.vraptor.plus.db.ebean;

import java.util.List;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.FindDb;

public class DefaultFindDb implements FindDb {

	public DefaultFindDb() {
	}
	
	@Override
	public <T> List<T> findAll(Class<T> type) {
		return Ebean.find(type).findList();
	}
	
	@Override
	public <T> List<T> findPaginate(Class<T> type, int first, int limit) {
		return Ebean.find(type)
				.setFirstRow(first)
				.setMaxRows(limit)
				.findList();
	}
	
	@Override
	public <T> T find(Class<T> type, long id) {
		return Ebean.find(type, id);
	}

}