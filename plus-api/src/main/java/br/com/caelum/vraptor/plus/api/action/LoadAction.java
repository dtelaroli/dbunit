package br.com.caelum.vraptor.plus.api.action;

public interface LoadAction extends Activity {

	<T> T by(Class<T> type, Object id);
	
}
