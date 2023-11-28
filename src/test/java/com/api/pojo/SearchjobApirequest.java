package com.api.pojo;

public class SearchjobApirequest {

	private int searchText ;

	public SearchjobApirequest(int search_job) {
		super();
		searchText = search_job;
	}

	public int getSearch_job() {
		return searchText;
	}

	public void setSearch_job(int search_job) {
		searchText = searchText;
	}

	@Override
	public String toString() {
		return "SearchjobApirequest [searchText=" + searchText + "]";
	}
}
