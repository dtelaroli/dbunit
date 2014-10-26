package br.com.caelum.vraptor.plus.api.action;

import java.util.List;

public interface ListAllAction extends Activity {

	<T> List<T> all(Class<T> type);
	
}
