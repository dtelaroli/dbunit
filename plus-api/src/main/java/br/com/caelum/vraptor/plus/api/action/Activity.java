package br.com.caelum.vraptor.plus.api.action;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.plus.api.Act;
import br.com.caelum.vraptor.plus.api.Database;

public interface Activity extends Act {

	Act withMessage(String message);

	Database db();

	Result result();

	String message();

}
