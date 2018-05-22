package com.pot.bean;

import java.util.HashMap;

public class FoodDetail {
	private int recipeId;
    private String image;
    private float score;
    private float time;
    private String source;
    private String other;
    private HashMap<Float, Float> map = new HashMap<>();
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public HashMap<Float, Float> getMap() {
		return map;
	}
	public void setMap(HashMap<Float, Float> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public FoodDetail(int recipeId, String image, float score, float time, String source, String other,
			HashMap<Float, Float> map) {
		super();
		this.recipeId = recipeId;
		this.image = image;
		this.score = score;
		this.time = time;
		this.source = source;
		this.other = other;
		this.map = map;
	}
	public FoodDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
