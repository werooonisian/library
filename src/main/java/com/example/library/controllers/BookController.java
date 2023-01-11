package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok().body(bookService.addBook(book));
    }

    @PostMapping("/{bookId}/addAuthor/{authorId}")
    public void addAuthorToBook(@PathVariable long bookId,
                                @PathVariable long authorId){
        bookService.addAuthorToBook(bookId, authorId);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable long bookId){
        return ResponseEntity.ok().body(bookService.getBook(bookId));
    }

    @DeleteMapping("/{bookId}/delete") //TODO: przemyśleć endpoint
    public void deleteBook(@PathVariable long bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping()
    public ResponseEntity<Book> editBook(@RequestBody Book book){
        return ResponseEntity.ok().body(bookService.editBook(book));
    }
}
