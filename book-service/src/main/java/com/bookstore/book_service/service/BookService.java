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

    public Book getBookById(Long id) {
        return repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Error......"));
    }

    public Book createBook(Book book) {
        return repo.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return repo.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setGenre(updatedBook.getGenre());
                    book.setPrice(updatedBook.getPrice());
                    return repo.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
