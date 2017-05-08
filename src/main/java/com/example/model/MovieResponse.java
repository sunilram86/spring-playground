package com.example.model;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Search", "totalResults", "Response"})
public class MovieResponse {
    private List<HashMap<String,Object>> search;


    private String totalResults;

    @JsonProperty ("Response")
    private String response;

    public MovieResponse() {
    }

    public MovieResponse(List<HashMap<String, Object>> search, String totalResults, String response) {
        this.search = search;
        this.totalResults = totalResults;
        this.response = response;
    }

    @JsonGetter("search")
    public List<HashMap<String, Object>> getSearch() {
        return search;
    }

    @JsonSetter("Search")
    public void setSearch(List<HashMap<String, Object>> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieResponse that = (MovieResponse) o;

        if (search != null ? !search.equals(that.search) : that.search != null) return false;
        if (totalResults != null ? !totalResults.equals(that.totalResults) : that.totalResults != null) return false;
        return response != null ? response.equals(that.response) : that.response == null;
    }

    @Override
    public int hashCode() {
        int result = search != null ? search.hashCode() : 0;
        result = 31 * result + (totalResults != null ? totalResults.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "search=" + search +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
