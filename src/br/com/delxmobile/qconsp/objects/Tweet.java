package br.com.delxmobile.qconsp.objects;

import java.util.List;

public class Tweet {

	private String max_id;
	private String previous_page;
	private String next_page;
	private List<Result> results;

	public String getMax_id() {
		return max_id;
	}

	public void setMax_id(String maxId) {
		max_id = maxId;
	}

	public String getPrevious_page() {
		return previous_page;
	}

	public void setPrevious_page(String previousPage) {
		previous_page = previousPage;
	}

	public String getNext_page() {
		return next_page;
	}

	public void setNext_page(String nextPage) {
		next_page = nextPage;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}	
}
