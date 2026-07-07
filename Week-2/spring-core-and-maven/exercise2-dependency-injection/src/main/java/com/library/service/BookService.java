package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // setter used by Spring for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected -> " + bookRepository);
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }
}
