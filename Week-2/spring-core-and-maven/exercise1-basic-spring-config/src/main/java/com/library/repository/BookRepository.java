package com.library.repository;

public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: saved book -> " + bookTitle);
    }

    public String findBook(String bookTitle) {
        return "BookRepository: found book -> " + bookTitle;
    }
}
