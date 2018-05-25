package com.dogukancelik.katip.respository;

import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.model.Book;
import com.dogukancelik.katip.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    Book findBySubName(String name);

    List<Book> findBySeriesName(String name);

    List<Book> findByAuthor(Author author);

    List<Book> findByPublisher(Publisher publisher);

    Book findByIsbn(String isbn);
}
