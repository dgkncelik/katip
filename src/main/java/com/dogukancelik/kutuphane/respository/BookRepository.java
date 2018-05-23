package com.dogukancelik.kutuphane.respository;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(String name);

    Optional<Book> findByName(String name);

    Optional<Book> findBySubName(String name);

    Optional<Book> findBySeriesName(String name);

    Optional<Book> findByAuthor(Author author);

    Optional<Book> findByPublisher(Publisher publisher);

    Optional<Book> findByIsbn(String isbn);
}
