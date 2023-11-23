package com.api.pojo;

public class SearchjobApirequest {

	private int Search_job ;

	public SearchjobApirequest(int search_job) {
		super();
		Search_job = search_job;
	}

	public int getSearch_job() {
		return Search_job;
	}

	public void setSearch_job(int search_job) {
		Search_job = search_job;
	}

	@Override
	public String toString() {
		return "SearchjobApirequest [Search_job=" + Search_job + "]";
	}
}
