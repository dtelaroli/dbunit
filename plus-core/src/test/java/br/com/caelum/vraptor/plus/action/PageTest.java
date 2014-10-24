package br.com.caelum.vraptor.plus.action;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PageTest {

	private Page page;
	private List<Object> emptyList;

	@Before
	public void setUp() throws Exception {
		emptyList = Collections.emptyList();
		page = new Page(1, 10, 100, emptyList);
	}

	@Test
	public void shouldSetPage() {
		assertThat(page.getPageNumber(), equalTo(1));
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
		page = new Page(2, 10, 100, emptyList);
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
		page.setPageNumber(2);
		assertThat(page.isFirstPage(), equalTo(false));
	}
	
	@Test
	public void shouldBeFalseIfNotIsLastPage() {
		assertThat(page.isLastPage(), equalTo(false));
	}
	
	@Test
	public void shouldBeTrueIfIsLastPage() {
		page.setPageNumber(10);
		assertThat(page.isLastPage(), equalTo(true));
	}
	
	@Test
	public void shouldBeTrueIfIsLastPageNotRounded() {
		page.setPageNumber(10);
		page.setTotal(101);
		assertThat(page.isLastPage(), equalTo(true));
	}
	
	@Test
	public void shouldReturnNextPage() {
		assertThat(page.getNextPage(), equalTo(2));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIsLastPage() {
		page.setPageNumber(10);
		page.getNextPage();
	}
	
	@Test
	public void shouldReturnPreviusPage() {
		page.setPageNumber(10);
		assertThat(page.getFirstPage(), equalTo(9));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionIfIsFirstPage() {
		page.getFirstPage();
	}
}
