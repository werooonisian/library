package com.example.library.services.implementations;

import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.models.Author;
import com.example.library.models.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void addAuthorToBook(long bookId, long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Author with id %s not found", authorId)));
        bookRepository.findById(bookId).ifPresentOrElse(book -> book.getAuthors().add(author),
                () -> { throw new ResourceNotFoundException(String.format("Book with id %s not found", bookId));});
    }

    @Override
    public Book getBook(long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
    }

    @Override
    public void deleteBook(long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
        book.getAuthors().forEach(author -> {
            author.getBooks().remove(book);
            authorRepository.save(author);
        });
        bookRepository.delete(book);
    }

    @Override
    public Book editBook(Book book) { //TODO: przemyśleć czy nie po id
        return bookRepository.save(book);
    }


}
