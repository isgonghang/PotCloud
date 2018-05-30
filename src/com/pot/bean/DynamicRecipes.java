package com.pot.bean;

public class DynamicRecipes {
	
    private long id;
    private String count_image;
    private String circle_image;
    private String name;
    private int like_count;
	public DynamicRecipes(long id, String count_image, String circle_image, String name, int like_count) {
		super();
		this.id = id;
		this.count_image = count_image;
		this.circle_image = circle_image;
		this.name = name;
		this.like_count = like_count;
	}
	public DynamicRecipes() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getCircle_image() {
		return circle_image;
	}
	public void setCircle_image(String circle_image) {
		this.circle_image = circle_image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	@Override
	public String toString() {
		return "StaticRecipes [id=" + id + ", count_image=" + count_image + ", circle_image=" + circle_image + ", name="
				+ name + ", like_count=" + like_count + "]";
	}



}
