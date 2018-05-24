package com.dogukancelik.kutuphane.respository;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    Book findBySubName(String name);

    List<Book> findBySeriesName(String name);

    List<Book> findByAuthor(Author author);

    List<Book> findByPublisher(Publisher publisher);

    Book findByIsbn(String isbn);
}
