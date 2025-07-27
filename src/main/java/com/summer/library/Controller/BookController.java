package com.summer.library.Controller;

import com.summer.library.Model.Book;
import com.summer.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/lpi")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/books")
    public Book storeBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> showBooks() {
        return bookService.findBook();
    }

//    @PutMapping("/books")
//    public boolean updateBook(@RequestParam int bookId, @RequestParam int bookNumber) {
//        return bookService.update_Book(bookId, bookNumber);
//    }
//
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/{bookId}")
    public Book oneBook(@PathVariable int bookId){
        return bookService.getBookById(bookId);
    }


}
