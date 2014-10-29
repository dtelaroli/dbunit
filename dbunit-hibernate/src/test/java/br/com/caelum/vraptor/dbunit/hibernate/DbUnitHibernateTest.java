package br.com.caelum.vraptor.dbunit.hibernate;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import models.MyModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class DbUnitHibernateTest {

	private DbUnitHibernate db;
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		db = new DbUnitHibernate();
		session = db.getSession();
	}

	@Test
	public void shouldReturnSession() {
		assertThat(session, instanceOf(Session.class));
		assertThat(session.isOpen(), equalTo(true));
	}
	
	@Test
	public void shouldInitDataBase() throws Exception {
		db.init(MyModel.class);
		
		MyModel model = (MyModel) session.load(MyModel.class, 1L);
		assertThat(model, instanceOf(MyModel.class));
		assertThat(model.getName(), equalTo("Name 1"));
	}
	
	@Test
	public void shouldInsertItem() throws Exception {
		db.init(MyModel.class);
		
		MyModel model = new MyModel();
		model.setName("Name 2");
		
		Transaction tx = session.beginTransaction();
		MyModel saved = (MyModel) session.merge(model);
		tx.commit();
		
		assertThat(saved.getId(), equalTo(2L));
	}

}
