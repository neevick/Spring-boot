package com.summer.library.Model;

import com.summer.library.Model.Records;

import java.awt.print.Book;
import java.util.Scanner;

public class User {
    private String userName;
    private int userContact;
    private int userId;

    public User(String userName, int userContact, int userId) {
        this.userName = userName;
        this.userContact = userContact;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserContact() {
        return userContact;
    }

    public void setUserContact(int userContact) {
        this.userContact = userContact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    Scanner scanner = new Scanner(System.in);

    public void isRegistered() {
        // TODO.................
    }

//    public void borrowBook(User user, Book book) {
//        if(book.getBookQuantity()>0) {
//            Records record = new Records(user, book, false);
//            book.decreaseQuantity();
//        }else {
//            System.out.println("Model.Book not available");
//        }
//    }

//    public void returnBook(){
//
//    }

}

