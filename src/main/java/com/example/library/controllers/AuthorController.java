package com.example.library.controllers;

import com.example.library.models.Author;
import com.example.library.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return ResponseEntity.ok().body(authorService.addAuthor(author));
    }

    @PutMapping("/edit")
    public ResponseEntity<Author>editAuthor(@RequestBody Author author){
        return ResponseEntity.ok().body(authorService.editAuthor(author));
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author>getAuthor(@PathVariable long authorId){
        return ResponseEntity.ok().body(authorService.getAuthor(authorId));
    }

    @DeleteMapping("/{authorId}/delete")
    public void deleteAuthor(@PathVariable long authorId){
        authorService.deleteAuthor(authorId);
    }
}
