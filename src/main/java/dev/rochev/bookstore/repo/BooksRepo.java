package dev.rochev.bookstore.repo;

import dev.rochev.bookstore.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepo extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT * from books", nativeQuery = true)
    List<Book> findAll();

    List<Book> findByTitle(String title);

    @Query(value = "select * from books b where b.id = :id", nativeQuery = true)
    Book findById(int id);



    Book save(Book book);

    @Modifying
    @Query(value = "delete from books b where b.id = :id", nativeQuery = true)
    void deleteById(int id);
}
