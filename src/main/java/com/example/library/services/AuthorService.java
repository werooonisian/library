package com.example.library.services;

import com.example.library.models.Author;

public interface AuthorService {
    Author addAuthor(Author author);
    Author editAuthor(Author author);
    Author getAuthor (long id);
    void deleteAuthor(long id);
}
