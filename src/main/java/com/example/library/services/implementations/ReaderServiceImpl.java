package com.example.library.services.implementations;

import com.example.library.models.Reader;
import com.example.library.repository.ReaderRepository;
import com.example.library.services.ReaderService;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }
}
