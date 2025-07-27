package com.summer.library.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Records {
    private User user;
    private Book book;
    private LocalDate borrowedTime;
    private boolean returnStatus;

    static ArrayList<Records> recordList = new ArrayList<>();

    public Records(User user, Book book, boolean returnStatus) {
        this.user = user;
        this.book = book;
        this.returnStatus = false;
    }
}
