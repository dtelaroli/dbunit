package br.com.caelum.vraptor.plus.api.db.pagination;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.test.MyModel;

public class PageTest {

	private Page<MyModel> page;
	private List<MyModel> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new MyModel());
		}
		
		page = new Page<MyModel>(1, 2, 10, list);
	}

	@Test
	public void shouldSetPage() {
		assertThat(page.getNumber(), equalTo(1));
	}

	@Test
	public void shouldSetLimit() {
		assertThat(page.getLimit(), equalTo(2));
	}
	
	@Test
	public void shouldSetList() {
		assertThat(page.getList(), equalTo(list));
	}
	
	@Test
	public void shouldSetFirstPage1() {
		assertThat(page.getFirst(), equalTo(1));
	}
	
	@Test
	public void shouldReturnTotal() {
		assertThat(page.getTotal(), equalTo(10));
	}
	
	@Test
	public void shouldBeFalseIfIsFirstPage() {
		assertThat(page.hasPrev(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfIsNotFirstPage() {
		page.setNumber(2);
		assertThat(page.hasPrev(), equalTo(true));
	}
	
	@Test
	public void shouldBeTrueIfNotIsLastPage() {
		assertThat(page.hasNext(), equalTo(true));
	}
	
	@Test
	public void shouldBeFalseIfIsLastPage() {
		page.setNumber(10);
		assertThat(page.hasNext(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfIsLastPageNotRounded() {
		page.setNumber(10);
		page.setTotal(101);
		assertThat(page.hasNext(), equalTo(true));
	}
	
	@Test
	public void shouldReturnNextPage() {
		assertThat(page.getNext(), equalTo(2));
	}
	
	@Test
	public void shouldReturnPreviusPage() {
		page.setNumber(10);
		assertThat(page.getPrev(), equalTo(9));
	}
	
	@Test
	public void shouldReturnSize() {
		assertThat(page.getPageSize(), equalTo(10));
	}

	@Test
	public void shouldReturnTrueIfHasNextPage() {
		page.setLimit(2);
		page.setNumber(1);
		page.setTotal(3);
		assertThat(page.hasNext(), equalTo(true));
	}
	
	@Test
	public void shouldReturnFalseIfNotHasNextPage() {
		page.setLimit(2);
		page.setNumber(1);
		page.setTotal(2);
		assertThat(page.hasNext(), equalTo(false));
	}
	
	@Test
	public void shouldReturnLastPage() {
		assertThat(page.getLast(), equalTo(5));
	}
	
	@Test
	public void shouldReturnLastPageTotalEqualLimit() {
		page.setTotal(3);
		page.setLimit(2);
		assertThat(page.getLast(), equalTo(2));
	}
}
