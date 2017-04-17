package com.example.workflow;

import java.util.List;

/**
 * Created by trainer13 on 4/15/17.
 */
public class Blog {
    private String title;
    private List<Article> articles;

    public Blog() {
    }

    public Blog(String title, List<Article> articles) {
        this.title = title;
        this.articles = articles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getTitle() {
        return title;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
