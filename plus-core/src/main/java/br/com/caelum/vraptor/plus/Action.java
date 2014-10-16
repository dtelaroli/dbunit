package br.com.caelum.vraptor.plus;


public interface Action {

	<T extends Act> T use(Class<T> act);
	
}
