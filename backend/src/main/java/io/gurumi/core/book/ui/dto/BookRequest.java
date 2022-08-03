package io.gurumi.core.book.ui.dto;

import io.gurumi.core.book.domain.Book;

public class BookRequest {
    private String title;
    private String article;

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public int getCost() {
        return cost;
    }

    private int cost;

    public Book toEntity(){
        return new Book
    }
}
