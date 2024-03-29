package com.api.pojo;

public class SearchjobApirequest {

	private String searchText;

    // Default constructor (needed for serialization/deserialization)
    public SearchjobApirequest() {
    }

    // Parameterized constructor
    public SearchjobApirequest(String searchText) {
        this.searchText = searchText;
    }

    // Getter for searchText
    public String getSearchText() {
        return searchText;
    }

    // Setter for searchText
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
