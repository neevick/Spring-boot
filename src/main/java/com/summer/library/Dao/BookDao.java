package com.summer.library.Dao;

import com.summer.library.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
    private Connection conn;

    public boolean insertBook(Book book) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "INSERT INTO book(bookNumber, bookName, bookQuantity, bookAuthor) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, book.getBookNumber());
            ps.setString(2, book.getBookName());
            ps.setInt(3, book.getBookQuantity());
            ps.setString(4, book.getBookAuthor());
            int row = ps.executeUpdate();
            if (row > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update_Book(int bookId, int bookNumber) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "UPDATE book SET bookNumber = ? WHERE bookid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bookNumber);
            ps.setInt(2, bookId);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete_Book(int bookId) {
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "DELETE FROM book WHERE bookId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bookId);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    public ArrayList<com.summer.library.Model.Book> show_Book() {
        ArrayList<Book> booklist = new ArrayList<>();
        try {
            conn = com.summer.library.Dao.DatabaseConnection.connect();
            String query = "SELECT bookId, BookNumber, BookName, BookAuthor, BookQuantity FROM book";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet bookSet = ps.executeQuery();//select gareesi execute vako
            while (bookSet.next()) {
                Book Book0 = new Book(bookSet.getInt("bookId"),bookSet.getInt("BookNumber"), bookSet.getString("BookName"), bookSet.getInt("BookQuantity"), bookSet.getString("BookAuthor"));
                booklist.add(Book0);
            }
            return booklist;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookInfo(int bookId) {
        Book book = null;
        try {
            Connection conn = DatabaseConnection.connect();
            String query = "SELECT bookId, bookNumber,bookName, bookQuantity, bookAuthor FROM book where bookId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bookId);
            ResultSet bookSet = ps.executeQuery();
            while (bookSet.next()) {
                book = new Book(
                        bookSet.getInt("bookId"),
                        bookSet.getInt("bookNumber"),
                        bookSet.getString("bookName"),
                        bookSet.getInt("bookQuantity"),
                        bookSet.getString("bookAuthor"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
