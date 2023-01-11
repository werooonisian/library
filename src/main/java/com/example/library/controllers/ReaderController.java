package com.example.library.controllers;

import com.example.library.models.Reader;
import com.example.library.services.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Reader> addReader(@RequestBody Reader reader){
        return ResponseEntity.ok().body(readerService.addReader(reader));
    }
}
