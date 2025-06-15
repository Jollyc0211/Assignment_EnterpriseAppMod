package com.example.Assignment2_Rest_JollyChristy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom queries can be added if needed
}
