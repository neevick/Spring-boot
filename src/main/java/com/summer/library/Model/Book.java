package com.summer.library.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private int bookNumber;
    private String bookName;
    private int bookQuantity;
    private String bookAuthor;

    public Book(){}

    public Book(int bookId, int bookNumber, String bookName, int bookQuantity, String bookAuthor) {
        this.bookId = bookId;
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void increaseQuantity(){
        this.bookQuantity ++;
    }

    public void decreaseQuantity(){
        this.bookQuantity --;
    }
}
