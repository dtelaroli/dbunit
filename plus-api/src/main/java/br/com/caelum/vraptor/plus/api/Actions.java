package br.com.caelum.vraptor.plus.api;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.plus.api.action.ListAllAction;
import br.com.caelum.vraptor.plus.api.action.PaginationAction;
import br.com.caelum.vraptor.plus.api.action.DeleteAction;
import br.com.caelum.vraptor.plus.api.action.PersistAction;
import br.com.caelum.vraptor.plus.api.action.LoadAction;

@Vetoed
public class Actions {

	public static Class<ListAllAction> list() {
		return ListAllAction.class;
	}

	public static Class<LoadAction> load() {
		return LoadAction.class;
	}
	
	public static Class<PersistAction> persist() {
		return PersistAction.class;
	}

	public static Class<PaginationAction> pagination() {
		return PaginationAction.class;
	}

	public static Class<DeleteAction> delete() {
		return DeleteAction.class;
	}

}
