package io.gurumi.core.book.ui.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String article;
    private int cost;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public int getCost() {
        return cost;
    }
}
