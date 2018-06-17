package com.akashsol.snomed.searchapi.util;

import java.util.List;

public class ResponseModel<T> {
	
	long count;
	List<SearchResultModel<T>> hitResults;
	
	
	public List<SearchResultModel<T>> getHitResults() {
		return hitResults;
	}
	public void setHitResults(List<SearchResultModel<T>> hitResults) {
		this.hitResults = hitResults;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}

}
