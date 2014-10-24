package br.com.caelum.vraptor.plus.api.db.pagination;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.plus.api.db.pagination.Page;
import br.com.caelum.vraptor.plus.api.test.MyModel;

public class PageTest {

	private Page<MyModel> page;
	private List<MyModel> emptyList;

	@Before
	public void setUp() throws Exception {
		emptyList = Collections.emptyList();
		page = new Page<MyModel>(1, 10, 100, emptyList);
	}

	@Test
	public void shouldSetPage() {
		assertThat(page.getNumber(), equalTo(1));
	}

	@Test
	public void shouldSetLimit() {
		assertThat(page.getLimit(), equalTo(10));
	}
	
	@Test
	public void shouldSetList() {
		assertThat(page.getList(), equalTo(emptyList));
	}
	
	@Test
	public void shouldSetFirstPage1() {
		assertThat(page.getFirst(), equalTo(0));
	}
	
	@Test
	public void shouldSetFirstPage2() {
		page = new Page<MyModel>(2, 10, 100, emptyList);
		assertThat(page.getFirst(), equalTo(10));
	}
	
	@Test
	public void shouldReturnTotal() {
		assertThat(page.getTotal(), equalTo(100));
	}
	
	@Test
	public void shouldBeTrueIfIsFirstPage() {
		assertThat(page.isFirstPage(), equalTo(true));
	}
	
	@Test
	public void shouldBeTrueIfIsNotFirstPage() {
		page.setNumber(2);
		assertThat(page.isFirstPage(), equalTo(false));
	}
	
	@Test
	public void shouldBeFalseIfNotIsLastPage() {
		assertThat(page.isLastPage(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfIsLastPage() {
		page.setNumber(10);
		assertThat(page.isLastPage(), equalTo(true));
	}
	
	@Test
	public void shouldBeTrueIfIsLastPageNotRounded() {
		page.setNumber(10);
		page.setTotal(101);
		assertThat(page.isLastPage(), equalTo(true));
	}
	
	@Test
	public void shouldReturnNextPage() {
		assertThat(page.getNext(), equalTo(2));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIsLastPage() {
		page.setNumber(10);
		page.getNext();
	}
	
	@Test
	public void shouldReturnPreviusPage() {
		page.setNumber(10);
		assertThat(page.getPrev(), equalTo(9));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIsFirstPage() {
		page.getPrev();
	}
	
	@Test
	public void shouldReturnSize() {
		assertThat(page.getPageSize(), equalTo(10));
	}
}
