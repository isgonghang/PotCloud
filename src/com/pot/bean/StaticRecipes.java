package com.pot.bean;

public class StaticRecipes {
	
    private Long id;
    private String name;
    private int like;
    private String time;
    private String image_left;
    private String image_right;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImage_left() {
		return image_left;
	}
	public void setImage_left(String image_left) {
		this.image_left = image_left;
	}
	public String getImage_right() {
		return image_right;
	}
	public void setImage_right(String image_right) {
		this.image_right = image_right;
	}
	@Override
	public String toString() {
		return "DynamicRecipes [id=" + id + ", name=" + name + ", like=" + like + ", time=" + time + ", image_left="
				+ image_left + ", image_right=" + image_right + "]";
	}
	public StaticRecipes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaticRecipes(Long id, String name, int like, String time, String image_left, String image_right) {
		super();
		this.id = id;
		this.name = name;
		this.like = like;
		this.time = time;
		this.image_left = image_left;
		this.image_right = image_right;
	}

}
