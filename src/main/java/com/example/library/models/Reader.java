package com.example.library.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "reader")
    private Set<BookCheckout> bookCheckouts;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<BookCheckout> getBookCheckouts() {
        return bookCheckouts;
    }

    public void setBookCheckouts(Set<BookCheckout> bookCheckouts) {
        this.bookCheckouts = bookCheckouts;
    }
}
