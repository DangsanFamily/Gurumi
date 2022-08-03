package io.gurumi.core.book.service;

import io.gurumi.core.book.domain.BookRepository;
import io.gurumi.core.book.ui.dto.BookRequest;
import io.gurumi.core.book.ui.dto.BookResponse;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook (BookRequest bookRequest){

    }
}
