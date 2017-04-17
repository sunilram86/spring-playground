package com.example.workflow;


public class Article {

    private String title;
    private String created_by;

    public Article() {
    }

    public Article(String title, String created_by) {
        this.title = title;
        this.created_by = created_by;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}

