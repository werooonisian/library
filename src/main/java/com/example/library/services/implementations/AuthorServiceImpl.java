package com.example.library.services.implementations;

import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.models.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author editAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> {throw new ResourceNotFoundException(String.format("Author with id %s not found", id));});
    }

    @Override //TODO: zmienić bo jest wiele do wielu i trzeba inaczej usuwać
    public void deleteAuthor(long id) {
        authorRepository.findById(id).ifPresentOrElse(author -> {
            //TODO: idk jeszcze jak to rozwiązać
                },
                () -> {throw new ResourceNotFoundException(String.format("Author with id %s not found", id));});
        //authorRepository.delete(author);
    }
}
