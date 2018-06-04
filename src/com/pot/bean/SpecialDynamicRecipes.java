package com.pot.bean;

public class SpecialDynamicRecipes {
    private long id;
    private String count_image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCount_image() {
		return count_image;
	}
	public void setCount_image(String count_image) {
		this.count_image = count_image;
	}
	@Override
	public String toString() {
		return "SpecialDynamicRecipes [id=" + id + ", count_image=" + count_image + "]";
	}
	public SpecialDynamicRecipes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpecialDynamicRecipes(long id, String count_image) {
		super();
		this.id = id;
		this.count_image = count_image;
	}
	
}
