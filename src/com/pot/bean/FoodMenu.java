package com.pot.bean;
/**
 * Created by ke on 2018/4/17.
 */

public class FoodMenu {
    private int id;
    private String name;
    private String count_image;
    private String circle_image;
    private int like_count;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodMenu(int id, String count_image, String circle_image, String name, int like_count) {
		super();
		this.id = id;
		this.count_image = count_image;
		this.circle_image = circle_image;
		this.name = name;
		this.like_count = like_count;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}