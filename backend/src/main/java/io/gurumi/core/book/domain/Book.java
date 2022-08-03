package io.gurumi.core.book.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost;
    private String article;
    private String title;

    public Book(String title, String article, int cost){
        this.title=title;
        this.article=article;
        this.cost=cost;
    }


}
