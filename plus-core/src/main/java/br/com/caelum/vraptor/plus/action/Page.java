package br.com.caelum.vraptor.plus.action;

import java.util.List;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class Page {

	private int pageNumber;
	private int limit;
	private List<Object> list;
	private int total;

	public Page() {
	}
	
	public Page(int pageNumber, int limit, int total, List<Object> list) {
		this.pageNumber = pageNumber;
		this.limit = limit;
		this.total = total;
		this.list = list;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getLimit() {
		return limit;
	}

	public List<Object> getList() {
		return list;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getFirst() {
		return (pageNumber - 1) * limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isFirstPage() {
		return pageNumber == 1;
	}

	public boolean isLastPage() {
		return pageNumber == total / limit;
	}

	public int getNextPage() {
		if(isLastPage()) {
			throw new UnsupportedOperationException("Last page");
		}
		return pageNumber + 1;
	}

	public int getFirstPage() {
		if(isFirstPage()) {
			throw new UnsupportedOperationException("First page");
		}
		return pageNumber - 1;
	}
	
}
