package com.example.library.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BookCheckout")
public class BookCheckout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO: book checkout 1-1 do książki i n-1 do czytelnika?
    @OneToOne(mappedBy = "bookCheckoutInfo")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
    private Date checkoutDate; //TODO: zapytać Justynkę czy nazwa i type ok sprawdzić??
    private Date returnDate; //TODO: return date czy date of return?? to samo wyżej

    //TODO: może zrobić jakis status czy książka przekroczyła czas możliwy do wypożyczenia i np jeśli tak to mail wysyłać
    //TODO: pomyśleć, czy usuwać cały obiekt wypożyczenie, czy ustawiać na nulle readera i daty


    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
