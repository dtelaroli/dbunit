package br.com.caelum.vraptor.plus;

public class MyModel {

	private Long id;

	public MyModel(long id) {
		this.id = id;
	}

	public MyModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
