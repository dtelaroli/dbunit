package br.com.caelum.vraptor.plus.api.db.pagination;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultPageConfig {
	
	public int getLimit() {
		return 20;
	}

}
