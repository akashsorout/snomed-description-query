package com.akashsol.snomed.searchapi.util;

public class SearchResultModel<T> {

	T component;
	float score;
	
	
	
	
	public T getComponent() {
		return component;
	}
	
	public void setComponent(T component) {
		this.component = component;
	}
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
