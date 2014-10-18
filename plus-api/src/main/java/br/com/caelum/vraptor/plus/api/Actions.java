package br.com.caelum.vraptor.plus.api;

import br.com.caelum.vraptor.plus.api.action.ListAllAction;
import br.com.caelum.vraptor.plus.api.action.PaginateAction;
import br.com.caelum.vraptor.plus.api.action.RemoveAction;
import br.com.caelum.vraptor.plus.api.action.SaveAction;
import br.com.caelum.vraptor.plus.api.action.ViewAction;

public class Actions {

	public static Class<ListAllAction> listAll() {
		return ListAllAction.class;
	}

	public static Class<ViewAction> view() {
		return ViewAction.class;
	}
	
	public static Class<SaveAction> save() {
		return SaveAction.class;
	}

	public static Class<PaginateAction> pagination() {
		return PaginateAction.class;
	}

	public static Class<RemoveAction> delete() {
		return RemoveAction.class;
	}

}
