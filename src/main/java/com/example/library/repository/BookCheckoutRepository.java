package com.example.library.repository;

import com.example.library.models.BookCheckout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCheckoutRepository extends JpaRepository<BookCheckout, Long> {
}
