package com.library.repository;

public class BookRepository {

    public void save(String bookTitle) {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("BookRepository: saved book -> " + bookTitle);
    }
}
