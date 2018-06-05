package com.pot.bean;

import java.util.TreeMap;

public class RecipesDetail {

	private Long recipeId;
    private String image;
    private float score;
    private int time;
    private String source;
    private String other;
    private TreeMap<Integer, Float> map = new TreeMap<>();
	public Long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Long recipeId) {
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
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

	public TreeMap<Integer, Float> getMap() {
		return map;
	}
	public void setMap(TreeMap<Integer, Float> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "RecipesDetail [recipeId=" + recipeId + ", image=" + image + ", score=" + score + ", time=" + time
				+ ", source=" + source + ", other=" + other + ", map=" + map + "]";
	}
	public RecipesDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecipesDetail(Long recipeId, String image, float score, int time, String source, String other,
			TreeMap<Integer, Float> map) {
		super();
		this.recipeId = recipeId;
		this.image = image;
		this.score = score;
		this.time = time;
		this.source = source;
		this.other = other;
		this.map = map;
	}
	
}
