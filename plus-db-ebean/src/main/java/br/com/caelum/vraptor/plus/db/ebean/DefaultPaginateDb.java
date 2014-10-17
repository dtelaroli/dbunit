package br.com.caelum.vraptor.plus.db.ebean;

import java.util.List;

import com.avaje.ebean.Ebean;

import br.com.caelum.vraptor.plus.api.db.PaginateDb;

public class DefaultPaginateDb implements PaginateDb {

	@Override
	public <T> List<T> all(Class<T> type, int first, int limit) {
		return Ebean.find(type)
				.setFirstRow(first)
				.setMaxRows(limit)
				.findList();
	}

}
