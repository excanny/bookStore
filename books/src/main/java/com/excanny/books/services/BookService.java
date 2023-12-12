package com.excanny.books.services;

import com.excanny.books.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book addOrUpdateBook(Book book);
    public List<Book> getAllBooks();
    public Optional<Book> getBookById(long id);
    public void deleteBook(long id);
}
