package com.library.repository;

public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: saved book -> " + bookTitle);
    }
}
