package model;

public abstract class Category {

	private String name;

	public Category(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
