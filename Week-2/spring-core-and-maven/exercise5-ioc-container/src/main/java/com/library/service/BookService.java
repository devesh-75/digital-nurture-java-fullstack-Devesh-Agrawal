package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerBook(String title) {
        bookRepository.addBook(title);
    }

    public void listBooks() {
        System.out.println("Books in library: " + bookRepository.getBooks());
    }
}
