package com.example.Assignment2_Rest_JollyChristy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Fetch full Publisher
        Long publisherId = book.getPublisher().getId();
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElse(null);

        // Fetch full Member
        Long memberId = book.getMember().getId();
        Member member = memberRepository.findById(memberId)
                .orElse(null);

        // Set full entities into Book
        book.setPublisher(publisher);
        book.setMember(member);

        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
