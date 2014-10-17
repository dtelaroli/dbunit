package br.com.caelum.vraptor.plus;

import br.com.caelum.vraptor.plus.action.ListAllAction;
import br.com.caelum.vraptor.plus.action.PaginateAction;
import br.com.caelum.vraptor.plus.action.RemoveAction;
import br.com.caelum.vraptor.plus.action.ViewAction;

public class Actions {

	public static Class<ListAllAction> listAll() {
		return ListAllAction.class;
	}

	public static Class<ViewAction> view() {
		return ViewAction.class;
	}

	public static Class<PaginateAction> paginate() {
		return PaginateAction.class;
	}

	public static Class<RemoveAction> remove() {
		return RemoveAction.class;
	}

}
