package dev.rochev.bookstore.controller;

import dev.rochev.bookstore.Book;
import dev.rochev.bookstore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return booksService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteBookById(@PathVariable("id") int id) {
        booksService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

    @PostMapping("/post")
    public @ResponseBody ResponseEntity<String> createBook(@RequestBody Book book) {
        booksService.addBook(book);
        return new ResponseEntity<String>("Book successfully added", HttpStatus.CREATED);
    }
}
