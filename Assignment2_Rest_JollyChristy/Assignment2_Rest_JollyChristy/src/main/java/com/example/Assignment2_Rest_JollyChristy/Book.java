package com.example.Assignment2_Rest_JollyChristy;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // Constructors
    public Book() {}

    public Book(Long id, String title, Publisher publisher, Member member) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.member = member;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}
