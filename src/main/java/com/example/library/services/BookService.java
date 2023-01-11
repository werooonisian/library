package com.example.library.services;

import com.example.library.models.Book;

public interface BookService {
    Book addBook(Book book);
    void addAuthorToBook(long bookId, long authorId);
    Book getBook(long id);
    void deleteBook(long id);
    Book editBook(Book book);
}
