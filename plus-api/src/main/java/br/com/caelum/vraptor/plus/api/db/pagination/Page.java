package br.com.caelum.vraptor.plus.api.db.pagination;

import java.util.List;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class Page<T> {

	private int number;
	private int limit;
	private List<T> list;
	private int total;

	public Page() {
	}
	
	public Page(int pageNumber, int limit, int total, List<T> list) {
		this.number = pageNumber;
		this.limit = limit;
		this.total = total;
		this.list = list;
	}

	public int getNumber() {
		return number;
	}

	public int getLimit() {
		return limit;
	}

	public List<T> getList() {
		return list;
	}
	
	public void setNumber(int pageNumber) {
		this.number = pageNumber;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getFirst() {
		return 1;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean hasPrev() {
		return number > 1;
	}

	public boolean hasNext() {
		return number * limit < total;
	}

	public int getNext() {
		if(!hasNext()) {
			return number;
		}
		return number + 1;
	}

	public int getPrev() {
		if(!hasPrev()) {
			return number;
		}
		return number - 1;
	}

	public int getPageSize() {
		return list.size();
	}

	public int getLast() {
		int last = (int) Math.ceil((double)total / limit);
		return last == 0 ? 1 : last;
	}
	
}
