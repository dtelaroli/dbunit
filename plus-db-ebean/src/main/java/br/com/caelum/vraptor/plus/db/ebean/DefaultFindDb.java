package br.com.caelum.vraptor.plus.db.ebean;

import java.util.List;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.FindDb;

public class DefaultFindDb implements FindDb {

	public DefaultFindDb() {
	}
	
	@Override
	public <T> List<T> all(Class<T> type) {
		return Ebean.find(type).findList();
	}
	
	@Override
	public <T> List<T> paginate(Class<T> type, int page, int limit) {
		return Ebean.find(type)
				.setFirstRow(getFirst(page, limit))
				.setMaxRows(limit)
				.findList();
	}

	private int getFirst(int page, int limit) {
		return (page - 1) * limit;
	}
	
	@Override
	public <T> T by(Class<T> type, long id) {
		return Ebean.find(type, id);
	}

}
