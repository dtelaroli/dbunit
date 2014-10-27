package br.com.caelum.vraptor.plus.api;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

public interface Action {

	<T extends Act> T use(Class<T> act);
	
	Result result();
	
	Validator validator();
	
}
