package com.example.model;


import java.util.Map;

public class WordResponse {

    private Map<String,Integer> map;


    public WordResponse() {
    }

    public WordResponse(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "WordResponse{" +
                "map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordResponse that = (WordResponse) o;

        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }
}
