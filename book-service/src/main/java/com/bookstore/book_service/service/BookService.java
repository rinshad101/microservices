package com.bookstore.book_service.service;

import com.bookstore.book_service.model.Book;
import com.bookstore.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }


    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}
