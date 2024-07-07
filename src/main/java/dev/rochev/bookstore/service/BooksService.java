package dev.rochev.bookstore.service;

import dev.rochev.bookstore.Book;
import dev.rochev.bookstore.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepo booksRepo;

    @Autowired
    public BooksService(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    public List<Book> getAllBooks() {
        return booksRepo.findAll();
    }

    public Book getBookById(@PathVariable("id") int id) {
        return booksRepo.findById(id);
    }

    @Transactional
    public String addBook(@RequestBody String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        booksRepo.save(book);
        return "Book added successfully";
    }

    @Transactional
    public void deleteBook(@PathVariable("id") int id) {
        booksRepo.deleteById(id);
    }

}
