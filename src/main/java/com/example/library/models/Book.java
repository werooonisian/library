package com.example.library.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
    @ManyToOne
    @JoinColumn(name = "publishingHouse_id", nullable = false)
    private PublishingHouse publishingHouse;
    private int year_of_publication;

    @NotNull(message = "Status may not be empty")
    @Enumerated(EnumType.STRING)
    private Status status;
    //TODO: może dodawanie zdjęcia do książki???

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookCheckout_id", referencedColumnName = "id")
    private BookCheckout bookCheckoutInfo;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BookCheckout getBookCheckoutInfo() {
        return bookCheckoutInfo;
    }

    public void setBookCheckoutInfo(BookCheckout bookCheckoutInfo) {
        this.bookCheckoutInfo = bookCheckoutInfo;
    }
}
