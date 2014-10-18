package br.com.caelum.vraptor.plus.api;

public interface Action {

	<T extends Act> T use(Class<T> act);
	
}
