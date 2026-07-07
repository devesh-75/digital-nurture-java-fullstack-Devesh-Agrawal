package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void save(String bookTitle) {
        System.out.println("BookRepository: saved book -> " + bookTitle);
    }
}
