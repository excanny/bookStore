package com.excanny.books.controllers;

import com.excanny.books.models.BaseResponse;
import com.excanny.books.models.Book;
import com.excanny.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book){
        var response = bookService.addOrUpdateBook(book);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        var response = bookService.getAllBooks();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        var response = bookService.getBookById(id).orElse(null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        var response = bookService.addOrUpdateBook(book);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully!.");
    }
}