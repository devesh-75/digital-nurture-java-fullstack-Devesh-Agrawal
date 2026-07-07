package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final BookRepository bookRepository;
    private String libraryName;

    // constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // setter injection
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(String title) {
        System.out.println("[" + libraryName + "]");
        bookRepository.save(title);
    }
}
